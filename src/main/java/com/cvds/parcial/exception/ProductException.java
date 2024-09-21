package com.cvds.parcial.exception;

public class ProductException extends Exception{
    public ProductException(String message){
        super(message);
    }

    public static class ProductDontHaveNull extends ProductException{
        public ProductDontHaveNull(String message) {
            super(message);
        }
    }

    public static class ProductDontExistsInDataBase extends ProductException {
        public ProductDontExistsInDataBase(String message) {
            super(message);
        }
    }

    public static class ProductAlreadyExitsInDatabse extends ProductException {
        public ProductAlreadyExitsInDatabse(String message) {
            super(message);
        }
    }
}
