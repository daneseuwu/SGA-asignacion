BEGIN;

INSERT INTO faculty (id_faculty, name, description) VALUES
    (1, 'Ingenieria y Tecnologia', 'Facultad enfocada en ingenieria, desarrollo y sistemas'),
    (2, 'Ciencias de la Salud', 'Facultad enfocada en salud, laboratorio y bienestar');

INSERT INTO career (id_career, name, code, description, duration, active, id_faculty) VALUES
    (1, 'Ingenieria en Software', 'ING-SW', 'Formacion en desarrollo de software y arquitectura', 5, TRUE, 1),
    (2, 'Ingenieria en Sistemas', 'ING-SIS', 'Gestion de infraestructura, redes y sistemas', 5, TRUE, 1),
    (3, 'Enfermeria', 'SAL-ENF', 'Formacion profesional en atencion de enfermeria', 4, TRUE, 2);

INSERT INTO professor (
    id_professor, first_name, last_name, code, document_identity, email, birth_date,
    genre, direction, phone, specialty, type_contract, status, id_faculty
) VALUES
    (1, 'Ana', 'Gomez', 'PROF-001', '0801-1990-00001', 'ana.gomez@universidad.edu', '1985-04-12',
     'femenino', 'Colonia Escalon, San Salvador', '7000-0001', 'Ingenieria de Software', 'full_time', 'active', 1),
    (2, 'Carlos', 'Rivera', 'PROF-002', '0801-1988-00002', 'carlos.rivera@universidad.edu', '1982-11-23',
     'masculino', 'Soyapango, San Salvador', '7000-0002', 'Bases de Datos', 'part_time', 'active', 1),
    (3, 'Marta', 'Perez', 'PROF-003', '0801-1985-00003', 'marta.perez@universidad.edu', '1980-02-17',
     'femenino', 'Santa Tecla, La Libertad', '7000-0003', 'Enfermeria Clinica', 'full_time', 'on_leave', 2);

INSERT INTO course (
    id_course, name, description, code, semester, is_active, id_professor, id_career, id_faculty
) VALUES
    (1, 'Programacion I', 'Fundamentos de programacion y logica de algoritmos', 'SW-101', 1, TRUE, 1, 1, 1),
    (2, 'Base de Datos', 'Modelado relacional, SQL y administracion basica', 'DB-201', 3, TRUE, 2, 2, 1),
    (3, 'Arquitectura de Software', 'Patrones, arquitectura y buenas practicas', 'SW-301', 5, TRUE, 1, 1, 1),
    (4, 'Anatomia y Fisiologia', 'Bases del cuerpo humano y su funcionamiento', 'ENF-110', 1, TRUE, 3, 3, 2);

INSERT INTO student (
    id_student, first_name, last_name, email, student_code, phone_number, birth_date,
    enrollment_date, status, id_career
) VALUES
    (1, 'Juan', 'Perez', 'juan.perez@estudiante.edu', 'EST-0001', '6000-0001', '2002-08-10',
     TIMESTAMP '2025-01-10 08:30:00', 'active', 1),
    (2, 'Maria', 'Lopez', 'maria.lopez@estudiante.edu', 'EST-0002', '6000-0002', '2001-03-21',
     TIMESTAMP '2025-01-11 09:15:00', 'active', 2),
    (3, 'Pedro', 'Hernandez', 'pedro.hernandez@estudiante.edu', 'EST-0003', '6000-0003', '2003-06-05',
     TIMESTAMP '2025-01-12 10:00:00', 'graduate', 1),
    (4, 'Sofia', 'Martinez', 'sofia.martinez@estudiante.edu', 'EST-0004', '6000-0004', '2002-12-02',
     TIMESTAMP '2025-01-13 11:45:00', 'suspended', 3);

INSERT INTO student_subject (id_student, id_course) VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4);

INSERT INTO enrollment (
    id_enrollment, section, status_enrollment, inscription_date, nota_final, attendance, id_student, id_course
) VALUES
    (1, 'A', 'enrolled', TIMESTAMP '2025-02-01 08:00:00', 88.5, '95%', 1, 1),
    (2, 'B', 'enrolled', TIMESTAMP '2025-02-01 08:15:00', 91.0, '97%', 2, 2),
    (3, 'A', 'enrolled', TIMESTAMP '2025-02-02 09:00:00', 79.0, '89%', 3, 3),
    (4, 'C', 'withdrawn', TIMESTAMP '2025-02-03 10:30:00', 0.0, '40%', 4, 4);

INSERT INTO grade (
    id_grade, evaluation_name, score, max_score, percentage, evaluation_date, status, id_enrollment
) VALUES
    (1, 'Parcial 1', 42.0, 50.0, 84.0, TIMESTAMP '2025-03-01 10:00:00', 'passed', 1),
    (2, 'Proyecto Final', 46.5, 50.0, 93.0, TIMESTAMP '2025-03-20 14:00:00', 'passed', 1),
    (3, 'Laboratorio 1', 18.0, 25.0, 72.0, TIMESTAMP '2025-03-05 11:30:00', 'pending', 2),
    (4, 'Examen Final', 15.0, 50.0, 30.0, TIMESTAMP '2025-03-22 16:00:00', 'failed', 3);

COMMIT;
