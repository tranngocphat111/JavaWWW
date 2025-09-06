<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body style="display: flex; justify-content: center; align-items: center;background-color: #a1d9e7">
<form action="registration-form" name="formDangKy" method="GET" style=" padding: 20px; border: 2px solid #fff; border-radius: 20px; width: 60%; display: flex; gap: 20px; flex-direction: column; color: #fff ; font-size: 20px">
    <div style="display: flex">
        <span style="min-width: 200px">First name</span>
        <input type="text" name="firstName">
        <span style="padding-left: 50px">(Max 30 characters a-z A-A)</span>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Last name</span>
        <input type="text" name="lastName">
        <span style="padding-left: 50px">(Max 30 characters a-z A-A)</span>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Date of birth</span>
        <input type="date" name="dateOfBirth">
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Email</span>
        <input type="email" name="email">
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Mobile number</span>
        <input type="text" name="mobileNumber">
        <span style="padding-left: 50px">(10 digit number)</span>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Gender</span>
        <div>
            <span>Male</span>
            <input type="radio" name="gender" value="Male">
        </div>
        <div>
            <span>Female</span>
            <input type="radio" name="gender" value="Female">
        </div>
    </div>


    <div style="display: flex">
        <span style="min-width: 200px">Address</span>
        <textarea name="address" style="height: 100px; width: 200px"> </textarea>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">City</span>
        <input type="text" name="city">
        <span style="padding-left: 50px">(Max 30 characters a-z A-A)</span>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Pin code</span>
        <input type="text" name="pinCode">
        <span style="padding-left: 50px">(6 digit number)</span>
    </div>


    <div style="display: flex">
        <span style="min-width: 200px">State</span>
        <input type="text" name="state">
        <span style="padding-left: 50px">(Max 30 characters a-z A-A)</span>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Country</span>
        <input type="text" name="country">
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Hobbies</span>
        <div>
            <span>Drawing</span>
            <input type="checkbox" name="hobbies" value="Drawing">
        </div>
        <div>
            <span>Singing</span>
            <input type="checkbox" name="hobbies" value="Singing">
        </div>
        <div>
            <span>Dancing</span>
            <input type="checkbox" name="hobbies" value="Dancing">
        </div>
        <div>
            <span>Sketching</span>
            <input type="checkbox" name="hobbies" value="Sketching">
        </div>
        <div>
            <span>Others</span>
            <input type="checkbox" name="hobbies" value="Others">
            <input type="text" name="txtOthers">
        </div>
    </div>


    <div style="display: flex">
        <span style="min-width: 200px">Qualification</span>
        <table style="border-collapse: collapse; width: 70%;">
            <tr>
                <th style="border: 1px solid white; padding: 8px;">Sl.No.</th>
                <th style="border: 1px solid white; padding: 8px;">Examination</th>
                <th style="border: 1px solid white; padding: 8px;">Board</th>
                <th style="border: 1px solid white; padding: 8px;">Percentage</th>
                <th style="border: 1px solid white; padding: 8px;">Year of Passing</th>
            </tr>

            <tr>
                <td style="border: 1px solid white; padding: 8px;">1</td>
                <td style="border: 1px solid white; padding: 8px;">Class X</td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="boardX" maxlength="10"
                                                                          style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="percentageX" maxlength="5"
                                                                          style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="yearX" maxlength="4"
                                                                          style="width: 95%;"></td>
            </tr>

            <tr>
                <td style="border: 1px solid white; padding: 8px;">2</td>
                <td style="border: 1px solid white; padding: 8px;">Class XII</td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="boardXII" maxlength="10"
                                                                          style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="percentageXII" maxlength="5"
                                                                          style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="yearXII" maxlength="4"
                                                                          style="width: 95%;"></td>
            </tr>

            <tr>
                <td style="border: 1px solid white; padding: 8px;">3</td>
                <td style="border: 1px solid white; padding: 8px;">Graduation</td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="boardGrad" maxlength="10"
                                                                          style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="percentageGrad"
                                                                          maxlength="5" style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;"><input type="text" name="yearGrad" maxlength="4"
                                                                          style="width: 95%;"></td>
            </tr>

            <tr>
                <td style="border: 1px solid white; padding: 8px;">4</td>
                <td style="border: 1px solid white; padding: 8px;">Masters</td>
                <td style="border: 1px solid white; padding: 8px;">
                    <input type="text" name="boardMasters" maxlength="10"
                           style="width: 95%;">
                </td>
                <td style="border: 1px solid white; padding: 8px;">
                    <input type="text" name="percentageMasters"
                           maxlength="5" style="width: 95%;"></td>
                <td style="border: 1px solid white; padding: 8px;">
                    <input type="text" name="yearMasters" maxlength="4"
                           style="width: 95%;"></td>
            </tr>
        </table>
    </div>

    <div style="display: flex">
        <span style="min-width: 200px">Course applies for</span>
        <div>
            <span>BCA</span>
            <input type="radio" name="course" value="BCA">
        </div>
        <div>
            <span>B.Corn</span>
            <input type="radio" name="course" value="B.Corn">
        </div>
        <div>
            <span>B.Sc</span>
            <input type="radio" name="course" value="B.Sc">
        </div>
        <div>
            <span>B.A</span>
            <input type="radio" name="course" value="B.A">
        </div>
    </div>

    <div style="display: flex; justify-content: center; gap: 50px">
        <button type="submit" style="padding: 14px; background-color: white ; border-radius: 10px">Submit</button>
        <button type="reset" style="padding: 14px; background-color: white ; border-radius: 10px">Reset</button>
    </div>


</form>
</body>
</html>