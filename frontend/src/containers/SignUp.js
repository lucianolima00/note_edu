import React, { useState } from 'react';
import {Link, useNavigate} from 'react-router-dom';
import { login } from '../api';
import Form from '../components/Form';
import TextInput from '../components/TextInput';
import api from '../services/api';

export default function SignUp({setUsername, setLoading, loading}) {
    let navigate = useNavigate();
    const [error, setError] = useState("");

    function handleSubmit(event) {
        event.preventDefault();
        if(!loading){
            setLoading(true);
            let formData = new FormData(event.currentTarget);
            let name = formData.get("name");
            let email = formData.get("email");
            let password = formData.get("password");
            api.post('/user', {name, email, password}).then(res => {
                res?.data && setUsername(res.data.name)
                setLoading(false);
                navigate("/");
            })
            // login({username, password}, (data) => {
            //     if(data.error){
            //         setError(data.error);
            //         console.log('data.error', data.error);
            //     } else {
            //         setUsername(data.name);
            //         navigate('/', { replace: true });
            //         console.log('data', data);
            //     }
            //     setLoading(false);
            // })
        }
    }

    return (
        <div>
            <Form title={"Sign Up"} onSubmit={handleSubmit}>
                <TextInput name={"name"} type={"text"} label={"Name"}/>
                <TextInput name={"email"} type={"text"} label={"Email"}/>
                <TextInput name={"password"} type={"password"} label={"Password"}/>
                {error && (<div>{error}</div>)}
                <button className={"primary"} type="submit">REGISTER</button><br/>
                <Link to={"/login"}>Already have an account? Sign In here</Link>
            </Form>
        </div>
    );
}