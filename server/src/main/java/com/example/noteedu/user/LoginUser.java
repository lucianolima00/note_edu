package com.example.noteedu.user;

import com.example.noteedu.customExceptions.NotFound;
import com.example.noteedu.customExceptions.WrongPassword;

public class LoginUser  extends User{

        public LoginUser(String name, String email,  String password) {
            super(name, email, password);
        }


        public int editar(Long id, String name, String email, String password) {
            int answer = 0;
            Class<? extends User> a;
            try {
                this.checkPassword(password);
                a = searchUser(email);

                
            }
            catch (Exception e) {
                if (e instanceof NotFound) {
                    System.out.println("Usu�rio n�o existe");
                }
                else if (e instanceof WrongPassword) {
                    System.out.println("password incorreta");
                }
                else {
                    System.out.println("Erro desconhecido");
                }
            }
            return answer;
        }

}


