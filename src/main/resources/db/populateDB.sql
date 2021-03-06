DELETE
FROM dishs;
DELETE
FROM USER_ROLES;
DELETE
FROM users;
DELETE
FROM restaurant;
DELETE
FROM voting;

ALTER SEQUENCE global_seq
RESTART WITH 100000;
INSERT INTO users ( NAME, EMAIL, PASSWORD )
VALUES   ('User', 'user@yandex.ru', 'password'),
         ('Admin', 'admin@gmail.com', 'admin');
INSERT INTO RESTAURANT (NAME)
VALUES ('Седьмое небо ' ),
       ('Кристалл '  ),
       ('ЛасВегас'  ),
       ('Вишенка'  ),
       ('Устрица' );
INSERT INTO user_roles (role, user_id) VALUES
       ('ROLE_USER', 100000),
       ('ROLE_ADMIN', 100001);

INSERT INTO dishs (RESTAURANT_ID, NAME, PRICE)
VALUES (100002, 'Запеканка', 155),
       (100002, 'Пюре с котлетой', 128),
       (100002, 'Кампот', 100),
       (100003, 'Суп с клецками', 165),
       (100003, 'Десерт', 111),
       (100003, 'Вермишель', 102),
       (100004, 'Чай', 154),
       (100004, 'Молочный суп', 122),
       (100004, 'Плов', 104),
       (100005, 'Сациви', 148),
       (100005, 'Кисель', 132),
       (100005, 'Суп Харчо', 99),
       (100006, 'Гуляш', 147),
       (100006, 'Гречка', 124),
       (100006, 'Борщ', 105);

INSERT INTO voting (  user_id, restaurant_id,date_time)
VALUES (100000,100002, '2019-12-01 15:44:50'),
       (100000,100002, '2019-11-13 15:44:50'),
       (100000,100002, '2019-10-15 15:44:50'),
       (100000,100002, '2019-09-16 15:44:50'),
       (100000,100002, '2019-08-17 15:44:50'),
       (100000,100003, '2019-07-16 15:44:50'),
       (100000,100003, '2019-06-15 15:44:50'),
       (100000,100003, '2019-05-14 15:44:50'),
       (100000,100003, '2019-04-15 15:44:50'),
       (100000,100003, '2019-03-17 15:44:50'),
       (100000,100004, '2019-02-21 15:44:50'),
       (100000,100004, '2019-01-23 15:44:50'),
       (100000,100004, '2019-12-24 15:44:50'),
       (100000,100004, '2019-12-25 15:44:50'),
       (100000,100004, '2019-11-26 15:44:50'),
       (100000,100005, '2019-10-27 15:44:50'),
       (100000,100005, '2019-09-28 15:44:50'),
       (100000,100005, '2019-08-29 15:44:50'),
       (100000,100005, '2019-07-30 15:44:50'),
       (100000,100005, '2019-06-01 15:44:50'),
       (100000,100006, '2019-05-11 15:44:50'),
       (100000,100006, '2019-04-14 15:44:50'),
       (100000,100006, '2019-01-17 15:44:50'),
       (100000,100006, '2019-03-06 15:44:50'),
       (100000,100006, '2018-02-08 15:44:50');





