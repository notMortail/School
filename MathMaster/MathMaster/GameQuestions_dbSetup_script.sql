-- -----------
-- Author: Muaaz Masood
-- CS3307- GROUP 35, MathMaster Game Question Database 
-- Database setup and questions insertion script 
-- Using sqlite3 on gaul as the database management system.

-- First step is to create the game questions database.
-- To run this script start this process by running the commented out commands below:
-- sqlite3 GameQuestions.db;
-- .read GameQuestions_dbSetup_script.sql

-- Second step is to create the table in the database
CREATE TABLE game_questions(question_number INT PRIMARY KEY, question TEXT, solution TEXT, question_type TEXT, question_difficulty TEXT, solution_verification_status INT, question_hint TEXT, hint_verification_status INT);

-- Third step is to insert questions and solutions into the database 
-- inserting addition questions
INSERT INTO game_questions VALUES ('1', '3 + 5', '8', 'addition', 'easy', '0', 'Add the numbers together using finger counting', '0');
INSERT INTO game_questions VALUES ('2', '27 + 48', '75', 'addition', 'easy', '0', 'Add the tens and ones separately, then combine: 20+40, 7+8, then combine to get the answer.','0');
INSERT INTO game_questions VALUES ('3', '12 + 8 + 5', '25', 'addition', 'easy', '0', 'Add each number one by one: 12+8, then add 5 to that result.','0');
INSERT INTO game_questions VALUES ('4', '356 + 219', '575', 'addition', 'easy', '0', 'Add the hundreds, tens, and ones separately, then combine: 300+200, 50+10, 6+9, then combine to get the answer.','0');
INSERT INTO game_questions VALUES ('5', '4.6 + 2.73', '7.33', 'addition', 'easy', '0', 'Add the whole numbers and decimals separately, then combine that result. Simply add decimals as you would with whole numbers.','0');
INSERT INTO game_questions VALUES ('6', '3,456,789 + 2,987,654', '6444443', 'addition', 'easy', '0', 'Add each digit separately, starting from the right.','0');

-- inserting subtraction questions
INSERT INTO game_questions VALUES ('7', '9 - 3', '6', 'subtraction', 'easy', '0', 'Remove 3 from 9. Use finger counting if necessary.','0');
INSERT INTO game_questions VALUES ('8', '45 - 18', '27', 'subtraction', 'easy', '0', 'Subtract the ones then tens digits.','0');
INSERT INTO game_questions VALUES ('9', '100 - 27', '73', 'subtraction', 'easy', '0', 'First remove 20 from 100, then remove 7 from that result.','0');
INSERT INTO game_questions VALUES ('10', '748 - 392', '356', 'subtraction', 'easy', '0', 'Subtract each digit separately, starting from the right.','0');
INSERT INTO game_questions VALUES ('11', '8.25 - 3.68', '4.57', 'subtraction', 'easy', '0', 'Subtract the whole numbers and decimals separately, then combine that result. Simply subtract decimals as you would with whole numbers.','0');
INSERT INTO game_questions VALUES ('12', '8,765 - 3,219', '5546', 'subtraction', 'easy', '0', 'Subtract each digit separately, starting from the right.','0');

-- inserting multiplication questions
INSERT INTO game_questions VALUES ('13', '6 x 7', '42', 'multiplication', 'easy', '0', 'Add 7 six times.','0');
INSERT INTO game_questions VALUES ('14', '4 x 8', '32', 'multiplication', 'easy', '0','Add 8 four times.','0');
INSERT INTO game_questions VALUES ('15', '9 x 0', '0', 'multiplication', 'easy', '0', 'Any number multiplied by 0 is ....?','0');
INSERT INTO game_questions VALUES ('16', '324 x 17', '5508', 'multiplication', 'easy', '0', 'Multiply each digit separately, starting from the right.','0');
INSERT INTO game_questions VALUES ('17', '3.5 x 2.5', '8.75', 'multiplication', 'easy', '0', 'Multiply the whole numbers and decimals separately, then combine that result. Simply multiply decimals as you would with whole numbers.','0');
INSERT INTO game_questions VALUES ('18', '789 x 456', '359784', 'multiplication', 'easy', '0', 'Multiply each digit separately, starting from the right.','0');
INSERT INTO game_questions VALUES ('19', '5.2 x 14', '72.8', 'multiplication', 'easy', '0', 'Multiply the whole numbers and decimals separately, then combine that result. Simply multiply decimals as you would with whole numbers.','0');

-- inserting division questions
INSERT INTO game_questions VALUES ('20', '63 / 7', '9', 'division', 'easy', '0', 'How many times can 7 go into 63?','0');
INSERT INTO game_questions VALUES ('21', '36 / 3', '12', 'division', 'easy', '0', 'Divide 3 from the tens digit, 3, then ones digit, 6.','0');
INSERT INTO game_questions VALUES ('22', '27 / 1', '27', 'division', 'easy', '0', 'Any number divided by 1 is ....?','0');
INSERT INTO game_questions VALUES ('23', '294 / 7', '42', 'division', 'easy', '0', 'Divide 29 by 7. Take that quotient as the next tens digit and 4 as the ones digit and divide by 7.','0');
INSERT INTO game_questions VALUES ('24', '8.4 / 2', '4.2', 'division', 'easy', '0', 'Divide 8 by 4. Divide decimals as you would with whole numbers. Combine the whole number and decimal result.','0');
INSERT INTO game_questions VALUES ('25', '5.6 / 0.4', '14', 'division', 'easy', '0', 'Divide decimals as you would with whole numbers. Keep in mind the decimal places for the final result.','0');

-- inserting fraction questions
INSERT INTO game_questions VALUES ('26', '1/4 + 3/8', '5/8', 'fraction', 'easy', '0', 'Find a common denominator and add.','0');
INSERT INTO game_questions VALUES ('27', '5.25 + 1/3', '5 7/12', 'fraction', 'easy', '0', 'Add the whole numbers and fractions separately and combine the answers.','0');
INSERT INTO game_questions VALUES ('28', '5 3/4 - 2 1/2', '3 1/4', 'fraction', 'easy', '0', 'Subtract the whole numbers and fractions separately and combine the answers.','0');
INSERT INTO game_questions VALUES ('29', '12.5 - 1/3', '12 1/6', 'fraction', 'easy', '0', 'Convert the decimal to a fraction, or fraction to a decimal to subtract.','0');
INSERT INTO game_questions VALUES ('30', '2/3 x 3/4', '1/2', 'fraction', 'easy', '0', 'Multiply the numerator and denominators separately.','0');
INSERT INTO game_questions VALUES ('31', '3/5 / 1/4', '4/5', 'fraction', 'easy', '0', 'Invert one of the fractions and multiply that with the other fraction.','0');
INSERT INTO game_questions VALUES ('32', '6378/42', '36 6/7', 'fraction', 'easy', '0', 'How many times does 42 go into 6,378? If it does not divide cleanly, use the quotient for the fraction.','0');

-- inserting geometry questions
INSERT INTO game_questions VALUES ('33', 'Find the area of right angle triange with a base of 6 units and a height of 8 units', '24 square units', 'geometry', 'medium', '0', 'Area of triangle is (1/2) * base * height. Base is 6 and height is 8.','0');
INSERT INTO game_questions VALUES ('34', 'Find the area of a rectangle with a length of 10 units and a width of 4 units', '40 square units', 'geometry', 'medium', '0', 'Area of rectangle is length * width. Length is 10 and width is 4.','0');
INSERT INTO game_questions VALUES ('35', 'Calculate the volume of a sphere with a radius of 5 units to the nearest tenths', '523.6 cubic units', 'geometry', 'medium', '0', 'Volume of a sphere is (4/3)*pi*r^3. r = radius is 5, pi is rounded to 3.14.','0');

-- inserting algebra questions
INSERT INTO game_questions VALUES ('36', 'Solve for x: 2x - 5 = 11', 'x = 8', 'algebra', 'medium', '0', 'Add 5 to both sides and divide by 2.','0');
INSERT INTO game_questions VALUES ('37', 'Solve for x: 3x + 5 = 17', 'x = 4', 'algebra', 'medium', '0', 'Subtract 5 from both sides and divide by 3.','0');
INSERT INTO game_questions VALUES ('38', 'Factor the expression: x^2 - 4', '(x - 2)(x + 2)', 'algebra', 'medium', '0', 'Quadratic formula is (-b±√(b²-4ac))/(2a). a is 1, b is 0, c is -4.','0');
INSERT INTO game_questions VALUES ('39', 'Simplify the expression: (2x^2)(3x^3)', '6x^5', 'algebra', 'medium', '0', 'Multiply the whole numbers and add the exponent values.','0');
INSERT INTO game_questions VALUES ('40', 'Solve the equation: 2(2x - 3) = 10', 'x = 4', 'algebra', 'medium', '0', 'Divide both sides by 2, add 3, then divide by 2 again.','0');
INSERT INTO game_questions VALUES ('41', 'Find the value of x: |x - 7| = 9', 'x = -2', 'algebra', 'medium', '0', '|-9| is 9. -7 and what results in -9?','0');

-- inserting quadratic equation questions
INSERT INTO game_questions VALUES ('42', 'Solve x^2 - 5x + 6 = 0 ', 'x = 2 or x = 3', 'quadratic', 'medium', '0', '(-b±√(b²-4ac))/(2a). A is 1, b is -5, c is 6.','0');
INSERT INTO game_questions VALUES ('43', 'Solve 2x^2 - 7x +3 = 0', 'x = 1/2 or x = 3', 'quadratic', 'medium', '0', 'Quadratic formula is (-b±√(b²-4ac))/(2a). a is 2, b is -7, c is 3.','0');
INSERT INTO game_questions VALUES ('44', 'Solve x^2 - 9 = 0', 'x = 3 or x = -3', 'quadratic', 'medium', '0', 'Quadratic formula is (-b±√(b²-4ac))/(2a). a is 1, b is 0, c is -9.','0');

-- inserting trignometry questions
INSERT INTO game_questions VALUES ('45', 'Find sin30', '1/2', 'trignometry', 'medium', '0', 'sin30 = cos60. sin 0 is 0, sin 90 is 1.','0');
INSERT INTO game_questions VALUES ('46', 'Find cos45', '√2/2', 'trignometry', 'medium', '0', 'cos45 = sin45. cos 0 is 1, cos 90 is 0.','0');
INSERT INTO game_questions VALUES ('47', 'Find sin60', '√3/2', 'trignometry', 'medium', '0', 'sin60 = cos30. sin 0 is 0, sin 90 is 1.','0');
INSERT INTO game_questions VALUES ('48', 'Find tan 45', '1', 'trignometry', 'medium', '0', 'tan45 = sin0 = cos90.','0');
INSERT INTO game_questions VALUES ('49', 'Find cos60', '1/2', 'trignometry', 'medium', '0', 'cos60 = sin30.  cos 0 is 1, cos 90 is 0.','0');
INSERT INTO game_questions VALUES ('50', 'Find tan60 + cot30', '2√3', 'trignometry', 'medium', '0', 'Find tan60 then cot30 and add cot30 = cosx/sinx.','0');
INSERT INTO game_questions VALUES ('51', 'Find sin45 + cos45', '√2', 'trignometry', 'medium', '0', 'sin45 = cos45','0');

-- inserting calculus questions
INSERT INTO game_questions VALUES ('52', 'Find the derivative of f(x) = 3x^2 - 4x + 2', '9x^2 - 4', 'calculus', 'medium', '0', 'Use the power rule for derivatives: n*x^(n-1). Each term may be calculated separately and combined at the end.','0');
INSERT INTO game_questions VALUES ('53', 'Find the derivative of f(x) = 3x^3 - 6x^2 + 2x - 7', '9x^2 - 12x + 2', 'calculus', 'medium', '0', 'Use the power rule for derivatives: n*x^(n-1). Each term may be calculated separately and combined at the end.','0');
INSERT INTO game_questions VALUES ('54', 'Evaluate the integral of ∫(2x^2 - 3x + 4) dx', '(2/3)x^3 - (3/2)x^2 + 4x + C, where C is the constant of integration', 'calculus', 'medium', '0', 'Use the power rule for integrals: (1/(n+1))*x^(n+1). Each term may be calculated separately and combined at the end.','0');


-- inserting calculus questions
INSERT INTO game_questions VALUES ('60', 'Find the derivative of f(x) = 3x^2 - 6x +2', '6x - 6', 'calculus', 'hard', '0', 'Use the power rule for derivatives: n*x^(n-1). Each term may be calculated separately and combined at the end.','0');
INSERT INTO game_questions VALUES ('61', 'Find the derivative of f(x) = e^x + 2x^2', 'e^x + 4x', 'calculus', 'hard', '0','Use the power rule for derivatives: n*x^(n-1). Each term may be calculated separately and combined at the end.','0');
INSERT INTO game_questions VALUES ('62', 'Determine the limit as x approaches infinity of (e^x) / (x^2)', ' The limit is 0', 'calculus', 'hard', '0','Use the power rule for integrals: (1/(n+1))*x^(n+1). Each term may be calculated separately and combined at the end.','0');

-- inserting linear algebra questions
INSERT INTO game_questions VALUES ('63', 'Find the determinant of a 3x3 matrix
                    | 2  0  1 |
                    | 3 -1  2 |
                    | 1  2  0 |', '-1', 'linear_algebra', 'hard', '0', 'Multiply the top left to bottom right diagonal and the top right to bottom left diagonal/ Subtract the second diagonal from the first.','0');
INSERT INTO game_questions VALUES ('64', 'Solve a system of linear equations
                    2x + 3y - z = 5
                    3x + y + 2z = 2
                    x - 2y + 3z = 7', 'x = -1, y = 2, z = -1', 'linear_algebra', 'hard', '0', 'Begin by isolating one variable, for example, express z in terms of x and y, then substitute into other equations for elimination.','0');
INSERT INTO game_questions VALUES ('65', 'Find the rank of a 4x4 matrix
                    | 1  2  0  3 |
                    | 0  1  0  4 |
                    | 0  3  0  2 |
                    | 0  0  0  1 |', '3', 'linear_algebra', 'hard', '0', 'Use row reduction to get the matrix in row-echelon form and count the number of non-zero rows.','0');
INSERT INTO game_questions VALUES ('66', 'Determine if the vectors (1, 2, 3) and (2, 4, 6) are linearly independent.', 'These vectors are linearly dependent since one is a scalar multiple of the other.', 'linear_algebra', 'hard', '0','Check if one vector is a scalar multiple of the other.','0');
INSERT INTO game_questions VALUES ('67', 'Find the eigenvalues and eigenvectors of the following 2x2 matrix
                    | 3  1 |
                    | 1  3 |', 'The eigenvalues are λ₁ = 4 and λ₂ = 2, and their corresponding eigenvectors are [1, 1] and [1, -1]', 'linear_algebra', 'hard', '0', 'Find the eigenvalues by solving: (det(A−λI)=0). Substitute each eigenvalue into (A−λI) to find the corresponding eigenvectors.','0');
INSERT INTO game_questions VALUES ('68', 'Find the eigenvalues of the following 3x3 matrix
                    | 2  1  0 |
                    | 1  3  1 |
                    | 0  1  2 |', 'The eigenvalues are λ₁ = 1, λ₂ = 3, λ₃ = 3', 'linear_algebra', 'hard', '0', 'Find the eigenvalues by solving: (det(A−λI)=0). Substitute each eigenvalue into (A−λI) to find the corresponding eigenvectors.','0');

-- inserting differential equation questions
INSERT INTO game_questions VALUES ('69', 'Solve the first-order linear differential equation: dy/dx + 2y = 4', 'y = 2 + Ce^(-2x), where C is a constant', 'differential_equation', 'hard', '0', 'Substitute y = uv, factor the parts involving v and use u to find v. Substitute u and v into y=uv to get the solution.','0');
INSERT INTO game_questions VALUES ('70', 'Solve the second-order differential equation: d^2y/dx^2 - 4dy/dx + 4y = 0', 'y = (C1 + C2x)e^(2x), where C1 and C2 are constants', 'differential_equation', 'hard', '0', 'Substitute y=e^(rx)  into the differential equation and solve for r to find characteristic roots.','0');
INSERT INTO game_questions VALUES ('71', 'Find the particular solution to the differential equation: dy/dx = 2x with the initial condition y(0) = 3', 'y = x^2 + 3', 'differential_equation', 'hard', '0', 'Integrate both sides with respect to x and use the initial condition to determine the value of constant C.','0');
INSERT INTO game_questions VALUES ('72', 'Solve the differential equation: d^2y/dx^2 - 9y = 0', 'y=c1e^(3x)+c2e^(-3x)', 'differential_equation', 'hard', '0', 'Find the characteristic equation, solve for r and construct the solution.','0');
INSERT INTO game_questions VALUES ('73', 'Find the general solution to the differential equation: dy/dx + y = x', 'ye^x = xe^x-e^x+C, where C is a constant.', 'differential_equation', 'hard', '0', 'Multiply both sides by e^x, rewrite the result and integrate both sides with respect to x.','0');

-- Fourth step is to setup the table for display and review the insertions
.header on 
.mode line
SELECT * FROM game_questions;

-- exit the database
.quit

