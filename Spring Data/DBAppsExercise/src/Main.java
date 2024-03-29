import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);

        // read credentials
        System.out.print("Enter username default (root): ");
        String username = sc.nextLine();
        username = username.equals("") ? "root" : username;
        System.out.println();
        System.out.print("Enter password default (empty): ");
        String password = sc.nextLine().trim();
        System.out.println();
        System.out.print(
                "Enter database URL default (jdbc:mysql://localhost:3306/minions_db):"
        );
        String url = sc.nextLine().trim();
        url = url.equals("") ? "jdbc:mysql://localhost:3306/minions_db" : url;
        System.out.println();

        // get connection
        Utils.setUsername(username);
        Utils.setPassword(password);
        Utils.setUrl(url);
        Connection connection = Utils.getSqlConnection();

        // execute commands until END
        while (true){
            System.out.println(Utils.chooseExerciseNum);
            String command = sc.nextLine().trim();
            if(command.equals("END")){
                break;
            } else if (command.equals("2")) {
                ResultSet villains = GetVilliansNames.getResultSet();
                GetVilliansNames.printToConsole(villains);

            } else if (command.equals("3")) {
                System.out.println("Enter villain ID: ");
                int villainID = Integer.parseInt(sc.nextLine());
                if(GetMinionsNames.existsVillainWithID(villainID)){
                    ResultSet minions = GetMinionsNames.getMinions(villainID);
                    String villainName = GetMinionsNames.getVillainName(villainID);
                    GetMinionsNames.printToConsole(villainName, minions);
                }else {
                    System.out.printf(
                            "No villain with ID %d exists in the database.\n"
                            , villainID
                    );
                }

            } else if (command.equals("4")) {
                System.out.println("Enter information in the format:");
                System.out.println("Minion: {minion_name} {minion_age} {town_name}");
                System.out.println("Villain: {villain_name}");

                // read info
                String[] minionAndTownInfo = sc.nextLine().split("\\s+");
                String[] villainInfo = sc.nextLine().split("\\s+");
                String minionName = minionAndTownInfo[1];
                int minionAge = Integer.parseInt(minionAndTownInfo[2]);
                String townName = minionAndTownInfo[3];
                String villainName = villainInfo[1];

                // add town if missing
                if(!AddMinion.existsTownWithName(townName)){
                    AddMinion.addTown(townName);
                    System.out.printf("Town %s was added to the database.\n", townName);
                }
                int townID = AddMinion.getTownIdByName(townName);

                // add villain if missing
                if(!AddMinion.existsVillainWithName(villainName)){
                    AddMinion.addVillain(villainName);
                    System.out.printf("Villain %s was added to the database.\n", villainName);
                }
                int villainID = AddMinion.getVillainIdByName(villainName);

                // add minion
                AddMinion.addMinion(minionName, minionAge, townID);
                int minionID = AddMinion.getMinionIdByName(minionName);
                AddMinion.setVillainOfMinion(minionID, villainID);
                System.out.printf("Successfully added %s to be minion of %s.\n"
                        , minionName, villainName);
                
            } else if (command.equals("5")) {
                System.out.println("Enter country name:");
                String countryName = sc.nextLine();

                // check if any towns with country
                if(ChangeTownNamesCasing.containsCountry(countryName)){
                    List<String> townNames = ChangeTownNamesCasing
                            .getTownNamesByCountry(countryName);
                    for(String townName : townNames){
                        ChangeTownNamesCasing.updateTownName(townName);
                    }

                    System.out.printf("%d town names were affected.\n[", townNames.size());
                    for (int i = 0; i < townNames.size() - 1; i++) {
                        System.out.printf("%s, ", townNames.get(i).toUpperCase());
                    }

                    System.out.printf("%s]\n", townNames
                            .get(townNames.size() - 1)
                            .toUpperCase());

                }else {
                    System.out.println("No town names were affected.");
                }
            } else if (command.equals("6")) {
                System.out.println("Enter Villain ID:");
                int villainID = Integer.parseInt(sc.nextLine());
                if(RemoveVillain.existsVillainWithID(villainID)){
                    String villainName = RemoveVillain.getVillainName(villainID);
                    int countOfMinions = RemoveVillain.getCountOfMinions(villainID);

                    // release minions first
                    RemoveVillain.releaseMinions(villainID);
                    // remove villain
                    RemoveVillain.deleteVillain(villainID);
                    System.out.printf("%s was deleted\n%d minions released\n"
                            , villainName, countOfMinions);

                }else {
                    System.out.println("No such villain was found");
                }

            } else if (command.equals("7")) {

                // results may vary due to minions removed / not removed from previous exercises
                List<String> namesInSpecialOrder = PrintAllMinionNames.getNamesInSpecialOrder();
                for(String name : namesInSpecialOrder){
                    System.out.println(name);
                }
                
            } else if (command.equals("8")) {
                System.out.println("Enter minion IDs separated by space:");
                int[] minionIDs = Arrays.stream(sc.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                // update every minion
                for(int minionID : minionIDs){
                    IncreaseMinionsAge.setMinionNameToLowercase(minionID);
                    IncreaseMinionsAge.incrementMinionAge(minionID);
                }

                // get and print all minions
                List<String> updatedMinions = IncreaseMinionsAge.getMinionsNamesAges();
                for(String minion : updatedMinions){
                    System.out.println(minion);
                }

            } else if(command.equals("9")){
                System.out.println("Enter minion ID:");
                int minionID = Integer.parseInt(sc.nextLine());
                IncreaseAgeStoredProcedure.incrementMinionAge(minionID);
                System.out.println(
                        IncreaseAgeStoredProcedure
                        .getFormattedNameAndAge(minionID)
                );
            }


            System.out.println();
        }

        // close connection at very end
        connection.close();
    }
}