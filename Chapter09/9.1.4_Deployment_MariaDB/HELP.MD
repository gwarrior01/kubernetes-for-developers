kubectl exec -it mariadb-client -- bash

mariadb -h mariadb -u root -p --skip-ssl

SHOW DATABASES;
USE mysql;
SHOW TABLES;

CREATE TABLE IF NOT EXISTS ping(id INT PRIMARY KEY AUTO_INCREMENT, msg VARCHAR(64));
INSERT INTO ping(msg) VALUES('hello from k8s');
SELECT * FROM ping;
