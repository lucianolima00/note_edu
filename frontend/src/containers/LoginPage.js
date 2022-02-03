import React, { useState } from 'react';
import {Link, useNavigate} from 'react-router-dom';
import { login } from '../api';
import Form from '../components/Form';
import TextInput from '../components/TextInput';
import api from '../services/api';

export default function LoginPage({setUsername, setLoading, loading}) {
    let navigate = useNavigate();
    const [error, setError] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        if(!loading){
            setLoading(true);
            let formData = new FormData(event.currentTarget);
            let email = formData.get("email");
            let password = formData.get("password");
            
            api.post('/user/login', {email, password}).then((res) => {
                const { data } = res;
                if(data && data.email){
                    console.log('a')
                    setUsername(data.name || data.email);
                    navigate('/', { replace: true });
                } else if(data.error){
                    console.log('b')
                    setError(data.message);
                }
                console.log('c')
                console.log('aqui1', data);
                setLoading(false);
            }, reason => {
                console.log('aqui2', reason);
                setLoading(false);
                setError("Email or password Incorrect");
            });
        }
    }

    return (
        <div>
            <Form title={"Login"} onSubmit={handleSubmit}>
                <TextInput name={"email"} type={"text"} label={"Email"}/>
                <TextInput name={"password"} type={"password"} label={"Password"}/>
                {error && (<div>{error}</div>)}
                <button className={"primary"} type="submit">Login</button><br/>
                <Link to="/signup">Don't have an account? Create one for free</Link>
            </Form>
        </div>
    );
}