-- Member Table

INSERT INTO member (id, name) VALUES (1, 'John Doe');
INSERT INTO member (id, name) VALUES (2, 'Jane Smith');
INSERT INTO member (id, name) VALUES (3, 'Alice Johnson');
INSERT INTO member (id, name) VALUES (4, 'Robert Brown');

-- Books

INSERT INTO book (book_id, name, title, author, sub_category, publisher, language)
VALUES (1, 'Flamingo', 'Fary tale', 'CBSE', 'school', 'Raj Pub', 'English');
INSERT INTO book (book_id, name, title, author, sub_category, publisher, language)
VALUES (2, 'RS', 'Maths By RS', 'CBSE', 'school', 'RS Pub', 'English');
INSERT INTO book (book_id, name, title, author, sub_category, publisher, language)
VALUES (3, 'RD', 'Logic Of Maths', 'CBSE', 'school', 'RD Pub', 'English');
INSERT INTO book (book_id, name, title, author, sub_category, publisher, language)
VALUES (4, 'SocialStudies', 'Geo-Politics', 'CBSE', 'school', 'Raj Pub', 'English');

-- Book Item

INSERT INTO book_items (id, status, book_id) VALUES (101, 'AVAILABLE', 1);
INSERT INTO book_items (id, status, book_id) VALUES (102, 'LOANED', 1);
INSERT INTO book_items (id, status, book_id) VALUES (201, 'AVAILABLE', 2);
INSERT INTO book_items (id, status, book_id) VALUES (202, 'AVAILABLE', 3);
INSERT INTO book_items (id, status, book_id) VALUES (203, 'AVAILABLE', 3);
INSERT INTO book_items (id, status, book_id) VALUES (301, 'LOANED', 4);
INSERT INTO book_items (id, status, book_id) VALUES (302, 'AVAILABLE', 2);

-- Loans

INSERT INTO loan (id, issue_dt, due_dt, return_dt, member_id, fine, book_item_id)
VALUES (501, '2026-01-10', '2026-01-24', '2026-01-20', 1, 0.0, 101);
INSERT INTO loan (id, issue_dt, due_dt, return_dt, member_id, fine, book_item_id)
VALUES (502, '2026-02-01', '2026-02-15', NULL, 2, 0.0, 102);
INSERT INTO loan (id, issue_dt, due_dt, return_dt, member_id, fine, book_item_id)
VALUES (503, '2026-02-05', '2026-02-19', NULL, 3, 0.0, 301);
INSERT INTO loan (id, issue_dt, due_dt, return_dt, member_id, fine, book_item_id)
VALUES (504, '2026-01-05', '2026-01-19', '2026-01-21', 4, 10.5, 201);

-- Reservations

INSERT INTO reservation (id, member_id, book_id, reservation_dt, status)
VALUES (601, 1, 1, '2026-02-08', 'WAITING');

INSERT INTO reservation (id, member_id, book_id, reservation_dt, status)
VALUES (602, 2, 2, '2026-02-09', 'NOTIFIED');

INSERT INTO reservation (id, member_id, book_id, reservation_dt, status)
VALUES (603, 3, 3, '2026-02-07', 'COMPLETED');

INSERT INTO reservation (id, member_id, book_id, reservation_dt, status)
VALUES (604, 4, 4, '2026-02-09', 'CANCELLED');


