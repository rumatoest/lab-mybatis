CREATE TABLE customers (
    id IDENTITY PRIMARY KEY, 
    enabled BOOLEAN,
    login VARCHAR(64),
    name VARCHAR(64),
    email VARCHAR(64),
    balance DECIMAL(20,2)
);


CREATE TABLE links (
    id IDENTITY PRIMARY KEY, 
    customer_id BIGINT,
    url VARCHAR(64),
);

INSERT INTO customers (enabled, login, name, email, balance) 
    VALUES (FALSE, 'tsar', 'Tsar Dadon', 'boss@dvorets.gov', 1000000);
INSERT INTO customers (enabled, login, name, email, balance) 
    VALUES (FALSE, 'ivan', 'Ivan Durak', 'ivandurak@banat.com', -100);
INSERT INTO customers (enabled, login, name, email, balance) 
    VALUES (TRUE, 'vasilisa', 'Vasilisa Premudraya', 'vasilisa@banat.com', 1000);
INSERT INTO customers (enabled, login, name, email, balance) 
    VALUES (TRUE, 'marpha', 'Marpha Boyarina', 'marpha@dvorets.gov', 55);

INSERT INTO links (customer_id, url) VALUES(1, 'http://dvorets.gov');
INSERT INTO links (customer_id, url) VALUES(1, 'http://baryni.dvorets.gov');
INSERT INTO links (customer_id, url) VALUES(1, 'http://tsar.dvorets.gov');

INSERT INTO links (customer_id, url) VALUES(2, 'http://banya.com');
INSERT INTO links (customer_id, url) VALUES(2, 'http://telki.rus');
INSERT INTO links (customer_id, url) VALUES(2, 'http://ruletka.rus');
INSERT INTO links (customer_id, url) VALUES(2, 'http://mmm2012.ug');

INSERT INTO links (customer_id, url) VALUES(3, 'http://wikipedia.rus');
INSERT INTO links (customer_id, url) VALUES(3, 'http://rukodeliye.rus');

INSERT INTO links (customer_id, url) VALUES(4, 'http://boyare.rus');
