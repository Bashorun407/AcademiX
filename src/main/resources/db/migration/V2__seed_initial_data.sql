-- ============================================
-- DEPARTMENTS
-- ============================================
INSERT INTO department (name) VALUES
('Computer Science'),
('Mathematics'),
('Physics');

-- ============================================
-- CLASSROOMS
-- ============================================
INSERT INTO classroom (room_number, capacity, max_room_capacity) VALUES
('A101', 30, 35),
('B202', 25, 30),
('C303', 40, 45);

-- ============================================
-- GUARDIANS
-- ============================================
INSERT INTO guardian (first_name, last_name, email, phone_number, profession) VALUES
('Michael', 'Smith', 'michael.smith@email.com', '08010000001', 'Engineer'),
('Sarah', 'Johnson', 'sarah.johnson@email.com', '08010000002', 'Doctor'),
('David', 'Brown', 'david.brown@email.com', '08010000003', 'Lawyer');

-- ============================================
-- STUDENTS
-- ============================================
INSERT INTO student (
    first_name,
    last_name,
    email,
    phone_number,
    student_reg_number,
    date_of_birth,
    guardian_id,
    classroom_id
)
VALUES
(
    'John',
    'Smith',
    'john.smith@student.com',
    '09020000001',
    'REG001',
    '2005-05-15',
    (SELECT id FROM guardian WHERE email = 'michael.smith@email.com'),
    (SELECT id FROM classroom WHERE room_number = 'A101')
),
(
    'Emily',
    'Johnson',
    'emily.johnson@student.com',
    '09020000002',
    'REG002',
    '2006-03-10',
    (SELECT id FROM guardian WHERE email = 'sarah.johnson@email.com'),
    (SELECT id FROM classroom WHERE room_number = 'B202')
),
(
    'Daniel',
    'Brown',
    'daniel.brown@student.com',
    '09020000003',
    'REG003',
    '2005-11-22',
    (SELECT id FROM guardian WHERE email = 'david.brown@email.com'),
    (SELECT id FROM classroom WHERE room_number = 'C303')
);

-- ============================================
-- TEACHERS
-- ============================================
INSERT INTO teacher (
    first_name,
    last_name,
    email,
    phone_number,
    employee_id,
    department_id
)
VALUES
(
    'Alice',
    'Walker',
    'alice.walker@school.com',
    '07030000001',
    'EMP001',
    (SELECT id FROM department WHERE name = 'Computer Science')
),
(
    'Robert',
    'Miller',
    'robert.miller@school.com',
    '07030000002',
    'EMP002',
    (SELECT id FROM department WHERE name = 'Mathematics')
);

-- ============================================
-- COURSES
-- ============================================
INSERT INTO course (
    course_code,
    title,
    credit_units,
    department_id
)
VALUES
(
    'CSC101',
    'Introduction to Programming',
    3,
    (SELECT id FROM department WHERE name = 'Computer Science')
),
(
    'MTH101',
    'Calculus I',
    4,
    (SELECT id FROM department WHERE name = 'Mathematics')
);

-- ============================================
-- ENROLLMENTS
-- ============================================
INSERT INTO enrollment (
    student_id,
    course_id,
    enrollment_date
)
VALUES
(
    (SELECT id FROM student WHERE student_reg_number = 'REG001'),
    (SELECT id FROM course WHERE course_code = 'CSC101'),
    CURRENT_DATE
),
(
    (SELECT id FROM student WHERE student_reg_number = 'REG002'),
    (SELECT id FROM course WHERE course_code = 'MTH101'),
    CURRENT_DATE
),
(
    (SELECT id FROM student WHERE student_reg_number = 'REG003'),
    (SELECT id FROM course WHERE course_code = 'CSC101'),
    CURRENT_DATE
);

-- ============================================
-- ATTENDANCE
-- ============================================
INSERT INTO attendance (
    date,
    status,
    student_id
)
VALUES
(
    CURRENT_DATE,
    'PRESENT',
    (SELECT id FROM student WHERE student_reg_number = 'REG001')
),
(
    CURRENT_DATE,
    'ABSENT',
    (SELECT id FROM student WHERE student_reg_number = 'REG002')
);

-- ============================================
-- FEES
-- ============================================
INSERT INTO fee (
    student_id,
    amount,
    is_paid,
    description,
    payment_status,
    reference_number,
    is_scholarship_applicable,
    due_date,
    created_at,
    updated_at,
    version
)
VALUES
(
    (SELECT id FROM student WHERE student_reg_number = 'REG001'),
    150000.00,
    FALSE,
    'First semester tuition fee',
    'PENDING',
    'REF-2026-0001',
    FALSE,
    CURRENT_DATE + INTERVAL '30 days',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    0
),
(
    (SELECT id FROM student WHERE student_reg_number = 'REG002'),
    120000.00,
    TRUE,
    'First semester tuition fee',
    'PAID',
    'REF-2026-0002',
    TRUE,
    CURRENT_DATE + INTERVAL '30 days',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    0
);
