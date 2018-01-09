INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'John', 'Smith', 'jsmith', 1); -- group A

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Jack', 'Watson', 'jwatson', 1); -- group A

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Marcus', 'Cruz', 'mcruz', 1); -- group A

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Thalia', 'Cobb', 'tcobb', 2); -- group B

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Joanna', 'Shaffer', 'jshaffer', 2); -- group B

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Diego', 'Stone', 'dstone', 2); -- group B

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Oliver', 'Harper', 'oharper', 3); -- group c

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Emilia', 'Haas', 'ehaas', 3); -- group C

INSERT INTO public.users (id, first_name, last_name, username, group_id)
VALUES (nextval('user_seq'), 'Lorenzo', 'Malone', 'lmalone', 3); -- group C