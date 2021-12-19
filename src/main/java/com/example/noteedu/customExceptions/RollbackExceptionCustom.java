package com.example.noteedu.customExceptions;

import javax.transaction.RollbackException;

public class RollbackExceptionCustom extends RollbackException {



        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public  RollbackExceptionCustom() {
            String message= null;
            String cause =null;

            message= this.getMessage();
            cause = String.valueOf(this.getCause());

            System.out.println("Variável que tentaram deletar está alocada.");
            System.out.println(message);
            System.out.println(cause);

        }

        /**
         * @param message
         */
        public RollbackExceptionCustom(String message) {
            super(message);

        }

        /**
         * @param cause
         */
        public RollbackExceptionCustom(Throwable cause) {
            super(String.valueOf(cause));

        }




}
