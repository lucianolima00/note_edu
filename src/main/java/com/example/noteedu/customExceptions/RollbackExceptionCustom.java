package com.example.noteedu.customExceptions;

import javax.persistence.RollbackException;

public class RollbackExceptionCustom extends RollbackException {


        /**
         *
         */
        private static final long serialVersionUID = 1L;

        public  RollbackExceptionCustom() {
            System.out.println("Não é possível apagar varíável em uso.");
        }

        public RollbackExceptionCustom(String message) {
            super(message);
        }

        public RollbackExceptionCustom(Throwable cause) {
            super(cause);
        }

        public RollbackExceptionCustom(String message, Throwable cause) {
            super(message, cause);
        }




}
