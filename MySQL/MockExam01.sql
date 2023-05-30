
create database colonial_journey_management_system_db;

create table planets(
	id int primary key auto_increment,
    `name` varchar(30) not null
);

create table spaceports(
	id int primary key auto_increment,
    `name` varchar(50) not null,
    planet_id int(11),
constraint fk_planet_id 
	foreign key (planet_id) references planets(id)
);

create table colonists(
	id int primary key auto_increment,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    ucn char(10)not null unique,
    birth_date date not null
);

create table spaceships(
	id int primary key auto_increment,
	`name` varchar(50) not null,
    manufacturer varchar(30) not null,
    light_speed_rate int default 0
);

create table journeys(
	id int primary key auto_increment,
	journey_start datetime not null,
    journey_end datetime not null,
    purpose enum('Medical', 'Technical', 'Educational', 'Military'),
    destination_spaceport_id int,
    spaceship_id int,
constraint fk_d_spaceport_id
	foreign key (destination_spaceport_id) references spaceports(id),
constraint fk_spaceship_id
	foreign key (spaceship_id) references spaceships(id)
);

create table travel_cards(
	id int primary key auto_increment,
	card_number char(10) not null unique,
    job_during_journey enum('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
    colonist_id int,
    journey_id int,
constraint fk_colonist_id 
	foreign key  (colonist_id) references colonists(id),
constraint fk_journey_id
	foreign key (journey_id) references journeys(id)
);

# 1. 


insert into travel_cards (card_number, job_during_journey, colonist_id, journey_id)
	select 
		(
        CASE
          WHEN c.birth_date > '1980-01-01'
				THEN concat_ws('', year(c.birth_date), day(c.birth_date), substr(c.ucn, 1, 4))
          ELSE 
				concat_ws('', year(c.birth_date), month(c.birth_date), substr(c.ucn, 7, 10))
        END
		) AS card_number,
        (
		case
			when c.id % 2 = 0
				then 'Pilot'
			when c.id % 3 = 0
				then 'Cook'
			else
				'Engineer'
		end
        ) as job_during_journey,
        c.id,
        (
        substr(c.ucn, 1, 1)
        ) as journey_id
	from colonists as c
	where c.id between 96 and 100;
        
        

# 2.

update journeys
	set purpose = (
    case 
		when id % 2 = 0 then 'Medical'
        when id % 3 = 0 then 'Technical'
        when id % 5 = 0 then 'Educational'
        when id % 7 = 0 then 'MIlitary'
        else purpose
	end
    );
    
    
# 3.

delete from colonists
	where id not in (
		select colonist_id
        from travel_cards tc);
        
        
        
# 4.

select card_number, job_during_journey
from travel_cards
order by card_number;



# 5

select id, concat_ws(' ', first_name, last_name) as `full_name`, ucn
from colonists
order by first_name, last_name, id;




# 6

select id, journey_start, journey_end
from journeys
where purpose = 'Military'
order by journey_start;



# 7

select c.id, concat_ws(' ', c.first_name, c.last_name) as `full_name`
from colonists as c
	join travel_cards as tc on c.id = tc.colonist_id 
where tc.job_during_journey = 'Pilot'
order by id;



# 8

select count(tc.colonist_id) as `count`
from journeys as j
	join travel_cards as tc on j.id = tc.journey_id
where j.purpose = 'Technical';




# 9
select ss.`name` as `spaceship_name`, sp.`name` as `spaceport_name`
from spaceships as ss
	join journeys as j on ss.id = j.spaceship_id
    join spaceports as sp on sp.id = j.destination_spaceport_id
order by ss.light_speed_rate desc
limit 1;



# 10

select ss.`name` as name, ss.manufacturer
from spaceships as ss
	join journeys as j on ss.id = j.spaceship_id
    join travel_cards as tc on tc.journey_id = j.id
    join colonists as c on tc.colonist_id = c.id
where tc.job_during_journey = 'Pilot'
	and year(c.birth_date) > year(DATE_SUB('2019-01-01', INTERVAL 30 YEAR))
order by ss.`name`;


# 11
select p.`name` as `planet_name`, sp.`name` as `spaceport_name`
from planets as p
	join spaceports as sp on p.id = sp.planet_id
    join journeys as j on sp.id = j.destination_spaceport_id
where j.purpose = 'Educational'
order by `spaceport_name` desc;




# 12
/*Extract from the database all planets’ names and their journeys count.
Order the results by journeys count, descending and by planet name ascending.
Required Columns
•	planet_name
•	journeys_count*/

select p.`name` as `planet_name`, 
	count(j.id) as `journeys_count`
from planets as p
	join spaceports as sp on p.id = sp.planet_id
    join journeys as j on sp.id = j.destination_spaceport_id
group by `planet_name`
order by `journeys_count` desc, `planet_name` asc;



# 13.
/*Extract from the database the shortest journey, its destination spaceport name, planet name and purpose.
Required Columns
•	Id
•	planet_name
•	spaceport_name
•	journey_purpose
*/

select j.id, p.`name` as `planet_name`, sp.`name` as `spaceport_name`, j.purpose as `journey_purpose`
FROM journeys j
JOIN spaceports sp on j.destination_spaceport_id = sp.id
JOIN planets p on sp.planet_id = p.id
order by datediff(j.journey_end, j.journey_start)
limit 1;



# 14
/*Extract from the database the less popular job in the longest journey.
In other words, the job with less assign colonists.
Required Columns
•	job_name
*/

select tc.job_during_journey as `job_name`
from travel_cards as tc
	join journeys as j on j.id = tc.journey_id
where tc.journey_id = (
	SELECT j.id
	FROM journeys j
	ORDER BY DATEDIFF(j.journey_end, j.journey_start) DESC
	LIMIT 1)
GROUP BY tc.job_during_journey
ORDER BY count(tc.job_during_journey)
limit 1;



# 15
/*Create a user defined function with the name udf_count_colonists_by_destination_planet (planet_name VARCHAR (30)) 
that receives planet name and returns the count of all colonists sent to that planet.*/

delimiter $$
create function udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
returns int
deterministic
begin
	select count(c.id)
    from planets as p
		join spaceports as sp on p.id = sp.planet_id
        join journeys as j on j.destination_spaceport_id = sp.id
        join travel_cards as tc on j.id = tc.id
        join colonists as c on tc.colonist_id = c.id
	where p.`name` = 'Otroyphus';
end
$$ delimiter ;

select count(c.id)
FROM colonists c
      JOIN travel_cards tc on c.id = tc.colonist_id
      JOIN journeys j on tc.journey_id = j.id
      JOIN spaceports s on j.destination_spaceport_id = s.id
      JOIN planets p on s.planet_id = p.id
where p.`name` = 'Otroyphus';

select count(c.id)
    from planets as p
		join spaceports as sp on p.id = sp.planet_id
        join journeys as j on j.destination_spaceport_id = sp.id
        join travel_cards as tc on j.id = tc.journey_id
        join colonists as c on tc.colonist_id = c.id
	where p.`name` = 'Otroyphus';



# 16
delimiter $$
create procedure udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11))
begin
	start transaction;
    if spaceship_name not in (select spaceships.name from spaceships)
		then
		signal sqlstate '45000' set message_text = 'Spaceship you are trying to modify does not exists.';
        rollback;
    else
		update spaceships
        set light_speed_rate = light_speed_rate + light_speed_rate_increse
        where `name` = spaceship_name;
    end if;
end
$$ delimiter ;