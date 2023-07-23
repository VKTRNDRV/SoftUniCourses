package hiberspring.service.impl;

import hiberspring.common.Constants;
import hiberspring.domain.dtos.ProductImportDTO;
import hiberspring.domain.dtos.ProductImportDtoWrapper;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.entities.Product;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.ProductRepository;
import hiberspring.service.ProductService;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private ModelMapper modelMapper;

    private XmlParser xmlParser;

    private BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, XmlParser xmlParser, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.branchRepository = branchRepository;
    }

    @Override
    public Boolean productsAreImported() {
        return this.productRepository.count() > 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return Files.readString(Path.of(Constants.PATH_TO_FILES + "products.xml"));
    }

    @Override
    public String importProducts() throws JAXBException {
        StringBuilder output = new StringBuilder();
        String xml = "<products></products>";
        try{
            xml = readProductsXmlFile();
        } catch (IOException ignored) {}
        ProductImportDtoWrapper wrapper = this.xmlParser
                .parseXml(ProductImportDtoWrapper.class, xml);
        List<ProductImportDTO> productDTOs = wrapper
                .getProductImportDTOs();
        boolean isValid;
        for(ProductImportDTO productImportDTO : productDTOs){
            isValid = !productImportDTO.containsInvalidNulls();
            Branch productBranch = null;
            if(isValid){
                Optional<Branch> branch = this.branchRepository
                        .findFirstByName(productImportDTO.getBranch());
                if(branch.isPresent()){
                    productBranch = branch.get();
                }else {
                    isValid = false;
                }
            }

            if(isValid){
                Product product = this.modelMapper
                        .map(productImportDTO, Product.class);
                product.setBranch(productBranch);
                this.productRepository.save(product);
                output.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,
                        "Product", product.getName()));

            }else {
                output.append(Constants.INCORRECT_DATA_MESSAGE);
            }
            output.append(System.lineSeparator());
        }
        return output.toString().trim();
    }
}
