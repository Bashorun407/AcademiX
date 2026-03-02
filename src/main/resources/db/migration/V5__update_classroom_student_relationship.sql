-- ============================================
-- ALTER TABLE: student
-- Update relationship to Many-to-One (Classroom -> Students)
-- ============================================

-- 1. Drop UNIQUE constraint on classroom_id (was enforcing one-to-one)
ALTER TABLE student
DROP CONSTRAINT IF EXISTS student_classroom_id_key;

-- 2. Drop existing foreign key to recreate cleanly (safe approach)
ALTER TABLE student
DROP CONSTRAINT IF EXISTS fk_student_classroom;

-- 3. Recreate foreign key (Many students can reference same classroom)
ALTER TABLE student
ADD CONSTRAINT fk_student_classroom
    FOREIGN KEY (classroom_id)
    REFERENCES classroom(id)
    ON DELETE SET NULL;

-- 4. Ensure index exists for better query performance
CREATE INDEX IF NOT EXISTS idx_student_classroom
    ON student(classroom_id);

-- ============================================
-- CLASSROOM TABLE
-- ============================================
-- No structural change required.
-- @OneToMany(mappedBy = "classroom") does not create a new column.
