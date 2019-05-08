DELETE FROM dishs;
DELETE FROM menus;
DELETE FROM users;
DELETE FROM restaurant;
ALTER SEQUENCE global_seq RESTART WITH 100000;


INSERT INTO RESTAURANT (  NAME ) VALUES
  ('Седьмое небо'),
  ('Кристал '),
  ('Бердянск ');

INSERT INTO menus (RESTAURANT_ID, VOTING )
VALUES (100000,3),
       (100001,2),
       (100002,1);

INSERT INTO dishs (MENU_ID, NAME, PRICE) VALUES
  (100003,'Картошка Фари', 121),
  (100003,'Суп гогоховый', 333),
  (100003,'Кампот', 213),
  (100004,'Каша гречневая', 14),
    (100004,'Котлета', 67),
  (100004,'Чай', 33),
    (100005,'Борщ', 34),
  (100005,'Пельмени', 45),
    (100005,'Кефир', 65),
  (100003,'Суп с клецками', 32),
    (100003,'Макароны по флотски', 54),
  (100003,'Молоко', 24);


INSERT INTO users (NAME,ISVOTING_TO_DEY  ) VALUES
  ('User',TRUE  ),
  ('Admin',TRUE   );



