package com.company;


public class ValidateInput
{
    public boolean isLetter(String input) { //check if string contains only letters
        return input.matches("[a-zA-Z]");
    }

    public boolean isNumber(String input){ //check if string contains only numbers
         return input.matches("[1-9]");
    }

}

