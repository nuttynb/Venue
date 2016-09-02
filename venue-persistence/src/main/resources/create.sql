INSERT INTO public.type( id, name ) VALUES (1, 'Rock kocsma');
INSERT INTO public.type( id, name ) VALUES (2, 'Rom kocsma');
INSERT INTO public.type( id, name ) VALUES (3, 'Bar');
INSERT INTO public.type( id, name ) VALUES (4, 'Nightclub');
INSERT INTO public.type( id, name ) VALUES (5, 'Disco');
INSERT INTO public.type( id, name ) VALUES (6, 'Pub');
INSERT INTO public.type( id, name ) VALUES (7, 'Beer hall');
INSERT INTO public.type( id, name ) VALUES (8, 'Beer garden');
INSERT INTO public.type( id, name ) VALUES (9, 'Tavern');
INSERT INTO public.type( id, name ) VALUES (10, 'Coffeehouse');
INSERT INTO public.type( id, name ) VALUES (11, 'Tea house');
INSERT INTO public.address( id, city, country, number, postcode, street ) VALUES (1, 'Debrecen', 'Magyarország', '9', 4026, 'Bethlen utca');
INSERT INTO public.venue( id,  name, description, ownerid, address_id, type_id) VALUES(1,'Teszt Venue Név', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.', 1, 1, 3);

