select * from autor;
select * from editorial;
select * from libro;
INSERT INTO Editorial (id, nombre, Alta)
VALUES
  ('82f3ef1e-59d1-48b6-95db-7685b5163ab7', 'Editorial Fantasía', true),
  ('5f4addd5-98be-4cc0-bdd2-428fd4b9c0c1', 'Libros Imaginarios', true),
  ('7e5b6140-7822-4e2b-b571-78e08a746f78', 'Ediciones Místicas', true),
  ('a7832145-8fc4-4b69-99a7-b89db79a85c6', 'Publicaciones Encantadas', true),
  ('e0d32e7d-8e50-4cc2-ba68-7770fd6941f4', 'Editorial de Ensueño', true),
  ('38dbd78e-2b9d-4fb7-b8a9-7fb97f4f5413', 'Ediciones Mágicas', true),
  ('d04237e1-3c4b-4911-b0d5-0d7ad337433d', 'Editorial de Fantasía', true);
  
INSERT INTO Autor (id, nombre, Alta)
VALUES
  ('f785ba33-1e9a-44d2-b774-1a2d6a124a01', 'Juan Pérez', true),
  ('4b0e0dc9-8056-4a6c-a2a2-79dc8979349b', 'María Gómez', true),
  ('a2f2dcce-8aae-41d5-b775-88b0d34b530c', 'Luis Ramírez', true),
  ('60276862-6d0c-4dca-b9f2-61ffdc2d9b35', 'Ana López', true),
  ('c8222515-7a78-4bc7-8620-398c9e5ebe8d', 'Carlos Rodríguez', true);
  
  INSERT INTO Libro (id, titulo, isbn, anio, Ejemplares, EjemplaresPrestados, EjemplaresRestantes, Alta, Autor_ID, Editorial_ID)
VALUES
  ('4dc6594b-145b-49e2-bd1d-0b1b25c8769d', 'El Gran Gatsby', 9780743273565, 1925, 10, 3, 7, true, 'f785ba33-1e9a-44d2-b774-1a2d6a124a01', '82f3ef1e-59d1-48b6-95db-7685b5163ab7'),
  ('a67071a6-7f7b-4287-b883-8c693f3e4e7f', '1984', 9780451524935, 1949, 8, 1, 7, true, '4b0e0dc9-8056-4a6c-a2a2-79dc8979349b', '5f4addd5-98be-4cc0-bdd2-428fd4b9c0c1'),
  ('1f50dc25-9539-4a4e-988f-132ac637b95d', 'Cien años de soledad', 9780307474728, 1967, 15, 5, 10, true, 'a2f2dcce-8aae-41d5-b775-88b0d34b530c', '7e5b6140-7822-4e2b-b571-78e08a746f78'),
  ('e7a20d88-2dc6-47ab-b76a-4c7801c62446', 'Matar a un ruiseñor', 9780061120084, 1960, 12, 0, 12, true, '60276862-6d0c-4dca-b9f2-61ffdc2d9b35', 'a7832145-8fc4-4b69-99a7-b89db79a85c6'),
  ('5d38efb7-75b0-42d9-b0e0-c78ef5e16af7', 'Don Quijote de la Mancha', 9788420674812, 1605, 20, 4, 16, true, 'c8222515-7a78-4bc7-8620-398c9e5ebe8d', 'e0d32e7d-8e50-4cc2-ba68-7770fd6941f4'),
  ('6b017caf-6635-4d3d-b4e2-d7ebf9f6f812', 'Ulises', 9788437600426, 1922, 7, 2, 5, true, 'f785ba33-1e9a-44d2-b774-1a2d6a124a01', '38dbd78e-2b9d-4fb7-b8a9-7fb97f4f5413'),
  ('28bca7a2-43e7-45e7-9e8b-7345b7e429b5', 'Moby-Dick', 9780142000083, 1851, 10, 2, 8, true, '4b0e0dc9-8056-4a6c-a2a2-79dc8979349b', 'd04237e1-3c4b-4911-b0d5-0d7ad337433d'),
  ('d1e20d34-25c3-4fd0-9500-5d187b33b330', 'Orgullo y prejuicio', 9780141439518, 1813, 12, 3, 9, true, 'a2f2dcce-8aae-41d5-b775-88b0d34b530c', '82f3ef1e-59d1-48b6-95db-7685b5163ab7'),
  ('c292122b-c39d-4b0b-8a79-bae1d74e6da9', 'En busca del tiempo perdido', 9788437616250, 1913, 20, 5, 15, true, '60276862-6d0c-4dca-b9f2-61ffdc2d9b35', '5f4addd5-98be-4cc0-bdd2-428fd4b9c0c1'),
  ('d5b32936-b493-4f1b-8b0c-3f8a0df4f2de', 'Crimen y castigo', 9788499892718, 1866, 8, 1, 7, true, 'f785ba33-1e9a-44d2-b774-1a2d6a124a01', 'e0d32e7d-8e50-4cc2-ba68-7770fd6941f4'),
  ('0a21f7e5-9e71-4e01-9423-440ca49a9f5f', 'Orgullo y prejuicio', 9788491046322, 1813, 12, 3, 9, true, '4b0e0dc9-8056-4a6c-a2a2-79dc8979349b', '38dbd78e-2b9d-4fb7-b8a9-7fb97f4f5413'),
  ('5d20b4d7-d34f-4a46-9fb6-dab6ab69682b', 'La Odisea', 9788499892714, 800 , 15, 4, 11, true, 'a2f2dcce-8aae-41d5-b775-88b0d34b530c','d04237e1-3c4b-4911-b0d5-0d7ad337433d'),
  ('6de1196d-19ed-4f94-b8a3-d416aa9b546f', 'El viejo y el mar', 9789871789215, 1952, 8, 2, 6, true, 'c8222515-7a78-4bc7-8620-398c9e5ebe8d', 'e0d32e7d-8e50-4cc2-ba68-7770fd6941f4'),
  ('e216a6f5-6c66-421f-9701-68a83c4d5169', 'Ensayo sobre la ceguera', 9789507311223, 1995, 15, 5, 10, true, 'f785ba33-1e9a-44d2-b774-1a2d6a124a01', 'd04237e1-3c4b-4911-b0d5-0d7ad337433d'),
  ('4a3e5d55-1c2c-4f9d-a393-11787d00b006', 'El nombre de la rosa', 9788497592804, 1980, 12, 3, 9, true, '4b0e0dc9-8056-4a6c-a2a2-79dc8979349b', '82f3ef1e-59d1-48b6-95db-7685b5163ab7'),
  ('3d6b2c12-7be0-41d3-8703-5c9d52eb62de', 'Rayuela', 9788432203053, 1963, 20, 6, 14, true, 'a2f2dcce-8aae-41d5-b775-88b0d34b530c', '5f4addd5-98be-4cc0-bdd2-428fd4b9c0c1'),
    ('3a4d73a3-69db-4f2e-8902-8d187f1eb449', 'La metamorfosis', 9788499892716, 1915, 10, 2, 8, true, 'c8222515-7a78-4bc7-8620-398c9e5ebe8d', '82f3ef1e-59d1-48b6-95db-7685b5163ab7'),
  ('e7a20d88-2dc6-47ab-b76a-4c7801c62441', 'Matar a un ruiseñor', 9780061120074, 1960, 12, 0, 12, true, '60276862-6d0c-4dca-b9f2-61ffdc2d9b35', 'a7832145-8fc4-4b69-99a7-b89db79a85c6');