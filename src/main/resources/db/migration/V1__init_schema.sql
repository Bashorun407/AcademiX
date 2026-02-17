-- ============================================
-- DEPARTMENT
-- ============================================
CREATE TABLE department (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

-- ============================================
-- CLASSROOM
-- ============================================
CREATE TABLE classroom (
    id BIGSERIAL PRIMARY KEY,
    room_number VARCHAR(255),
    capacity INTEGER NOT NULL,
    max_room_capacity INTEGER NOT NULL
);

-- ============================================
-- GUARDIAN (extends Person)
-- ============================================
CREATE TABLE guardian (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(255) UNIQUE,
    profession VARCHAR(255)
);

-- ============================================
-- STUDENT (extends Person)
-- ============================================
CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(255) UNIQUE,
    student_reg_number VARCHAR(255),
    date_of_birth DATE,
    guardian_id BIGINT,
    classroom_id BIGINT UNIQUE,

    CONSTRAINT fk_student_guardian
        FOREIGN KEY (guardian_id)
        REFERENCES guardian(id)
        ON DELETE SET NULL,

    CONSTRAINT fk_student_classroom
        FOREIGN KEY (classroom_id)
        REFERENCES classroom(id)
        ON DELETE SET NULL
);

-- ============================================
-- TEACHER (extends Person)
-- ============================================
CREATE TABLE teacher (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    phone_number VARCHAR(255) UNIQUE,
    employee_id VARCHAR(255),
    department_id BIGINT,

    CONSTRAINT fk_teacher_department
        FOREIGN KEY (department_id)
        REFERENCES department(id)
        ON DELETE SET NULL
);

-- ============================================
-- COURSE
-- ============================================
CREATE TABLE course (
    id BIGSERIAL PRIMARY KEY,
    course_code VARCHAR(255),
    title VARCHAR(255),
    credit_units INTEGER NOT NULL,
    department_id BIGINT,

    CONSTRAINT fk_course_department
        FOREIGN KEY (department_id)
        REFERENCES department(id)
        ON DELETE SET NULL
);

-- ============================================
-- ENROLLMENT
-- ============================================
CREATE TABLE enrollment (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT,
    course_id BIGINT,
    enrollment_date DATE DEFAULT CURRENT_DATE,

    CONSTRAINT fk_enrollment_student
        FOREIGN KEY (student_id)
        REFERENCES student(id)
        ON DELETE CASCADE,

    CONSTRAINT fk_enrollment_course
        FOREIGN KEY (course_id)
        REFERENCES course(id)
        ON DELETE CASCADE
);

-- ============================================
-- ATTENDANCE
-- ============================================
CREATE TABLE attendance (
    id BIGSERIAL PRIMARY KEY,
    date DATE,
    status VARCHAR(50),
    student_id BIGINT,

    CONSTRAINT fk_attendance_student
        FOREIGN KEY (student_id)
        REFERENCES student(id)
        ON DELETE CASCADE
);

-- ============================================
-- FEE
-- ============================================
CREATE TABLE fee (
    id BIGSERIAL PRIMARY KEY,
    student_id BIGINT,
    amount NUMERIC(19,2) NOT NULL,
    is_paid BOOLEAN NOT NULL DEFAULT FALSE,
    description TEXT,
    payment_status VARCHAR(50),
    reference_number VARCHAR(255) NOT NULL UNIQUE,
    is_scholarship_applicable BOOLEAN NOT NULL DEFAULT FALSE,
    due_date DATE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    version INTEGER,

    CONSTRAINT fk_fee_student
        FOREIGN KEY (student_id)
        REFERENCES student(id)
        ON DELETE CASCADE
);

-- ============================================
-- INDEXES (recommended for FK performance)
-- ============================================
CREATE INDEX idx_student_guardian ON student(guardian_id);
CREATE INDEX idx_student_classroom ON student(classroom_id);
CREATE INDEX idx_teacher_department ON teacher(department_id);
CREATE INDEX idx_course_department ON course(department_id);
CREATE INDEX idx_enrollment_student ON enrollment(student_id);
CREATE INDEX idx_enrollment_course ON enrollment(course_id);
CREATE INDEX idx_attendance_student ON attendance(student_id);
CREATE INDEX idx_fee_student ON fee(student_id);
