package com.example.noteedu.user;

import com.example.noteedu.customExceptions.NotFound;
import com.example.noteedu.customExceptions.WrongPassword;

public class LoginUser extends User {


        public LoginUser(String name, String email, String password, Long id) {
            super(name, email, password, id);
        }


        public int update(String name, String email, String password, Long id) {

            String answer = null;
            try {
                this.checkPassword(password);
                answer = String.valueOf(searchUser(email));
               System.out.println(answer); //placeholder
            }
            catch (Exception e) {
                if (e instanceof NotFound) {
                    System.out.println("Usu�rio n�o existe");
                }
                else if (e instanceof WrongPassword) {
                    System.out.println("Senha incorreta");
                }
                else {
                    System.out.println("Erro desconhecido");
                }
            }
            return answer;
        }


}
