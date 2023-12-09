SELECT count(customer_id) FROM movie.customer;

USE movie;
SELECT * FROM customer ORDER BY customer_id DESC LIMIT 10;

SELECT * FROM address ORDER BY address_id DESC LIMIT 10;

SELECT c.city_id, c.city, c2.country FROM city c JOIN country c2 on c2.country_id = c.country_id where city_id=435;

SELECT * FROM rental WHERE return_date is null LIMIT 2;

SELECT * FROM rental WHERE rental_id=11496;

SELECT * FROM film LIMIT 10;

SELECT * FROM payment ORDER BY payment_id DESC LIMIT 10;

SELECT a.* FROM actor a JOIN film_actor fa ON a.actor_id=fa.actor_id JOIN film f ON fa.film_id=f.film_id WHERE f.title ='ALASKA PHANTOM';

SELECT a.* FROM actor a JOIN film_actor fa ON a.actor_id=fa.actor_id WHERE fa.film_id =17;

SELECT a.last_name, a.first_name, f.*  FROM film f JOIN film_actor fa on f.film_id = fa.film_id JOIN actor a on a.actor_id = fa.actor_id WHERE a.actor_id=66;

SELECT count(f.film_id)  FROM film f JOIN film_actor fa on f.film_id = fa.film_id JOIN actor a on a.actor_id = fa.actor_id WHERE a.actor_id=66;

select filmentity0_.film_id as film_id1_6_
     , filmentity0_.description as descript2_6_
     , filmentity0_.language_id as languag12_6_
     , filmentity0_.last_update as last_upd3_6_
     , filmentity0_.length as length4_6_
     , filmentity0_.original_language_id as origina13_6_
     , filmentity0_.rating as rating5_6_
     , filmentity0_.release_year as release_6_6_
     , filmentity0_.rental_duration as rental_d7_6_
     , filmentity0_.rental_rate as rental_r8_6_
     , filmentity0_.replacement_cost as replacem9_6_
     , filmentity0_.special_features as special10_6_
     , filmentity0_.title as title11_6_
from film filmentity0_ left outer join actor actorentit1_ on filmentity0_.film_id=actorentit1_.actor_id where actorentit1_.actor_id=44;
