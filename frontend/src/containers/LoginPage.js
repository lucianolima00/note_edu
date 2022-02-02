import React, { useState } from 'react';
import {useNavigate} from 'react-router-dom';
import { login } from '../api';

export default function LoginPage({setUsername, setLoading, loading}) {
    let navigate = useNavigate();
    const [error, setError] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        if(!loading){
            setLoading(true);
            let formData = new FormData(event.currentTarget);
            let username = formData.get("username");
            let password = formData.get("password");
            
            login({username, password}, (data) => {
                if(data.error){
                    setError(data.error);
                    console.log('data.error', data.error);
                } else {
                    setUsername(data.name);
                    navigate('/', { replace: true });
                    console.log('data', data);
                }
                setLoading(false);
            })
        }
    }

    return (
        <div>
            <p>You must log in to view the page at my ass</p>

            <form onSubmit={handleSubmit}>
                <label>
                    Username: 
                    <input name="username" type="text" />
                </label>
                <br/>
                <label>
                    Password: 
                    <input name="password" type="text" />
                </label><br/>
                {error && (<div>{error}</div>)}
                <button type="submit">Login</button>
            </form>
        </div>
    );
}