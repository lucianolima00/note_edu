import fakedb from './fakedb.json';

export const login = ({username, password}, callback) => {
    let user = {error: "Usuário não encontrado"};
    fakedb.users.map(u => {
        if(u.name == username){
            if(u.password == password){
                user = u;
            } else {
                user = {error: "Senha incorreta"};
            }
        }
    });
    return setTimeout(() => callback(user), 2000);
    
    // return false;
}

export const getNotebooks = (username, callback) => {
    let notebooks = [];
    fakedb.users.map(
        u=>{
            if (u.name == username){
                notebooks = u.notebook;
            }
        }
    );
    return callback(notebooks);
}
