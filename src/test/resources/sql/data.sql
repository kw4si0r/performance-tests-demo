

insert into user(u_type, u_email) values
    (10, 'user1@pm.me')
    ,(20, 'user2@gmail.com');

insert into user_details(d_email, d_name, d_surname) values
    ('user1@pm.me', 'jan','nowak')
    ,('user2@gmail.com', 'john','doe');


insert into country(s_id, s_status, s_created, s_name) values
    (1, 1, '2023-01-01', 'Poland')
    , (2, 1, '2022-01-01', 'USA');


insert into city(c_id, c_other, c_status, c_name) values
    (1, 1, 1, 'Krakow')
    , (2, 1, 1, 'Warszawa')
    , (3, 2, 1, 'Chicago')
;
