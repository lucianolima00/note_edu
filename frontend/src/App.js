import React, {useState, useEffect} from 'react';
// import logo from './logo.svg';
// import './App.css';
import LoginPage from './containers/LoginPage';
import { Navigate, useRoutes } from 'react-router-dom';
import Dashboard from './containers/Dashboard';
import UIState from './components/UIState';
import Header from './components/Header';
import api from './services/api';
import { AddReminder } from './containers/AddReminder';
import { AddPostit } from './containers/AddPostit';
import SignUp from './containers/SignUp';

function App() {
  const [username, setUsername] = useState("");
  const [userId, setUserId] = useState("");
  const [loading, setLoading] = useState(false);
  const [notebooks, setNotebooks] = useState([]);
  const [reminders, setReminders] = useState([]);
  const [postits, setPostits] = useState([]);

  useEffect(() => {
    // if(!username){
    //   api.get('/user').then(response => {
    //     console.log(response)
    //     setUsername(response.data)
    //   });
    // }
      api.get('/notebook').then(response => {
        console.log(response);
        setNotebooks(response.data)
      });
      api.get('/reminder').then(response => {
        setReminders(response.data)
      });
      api.get('/postIt').then(response => {
        setPostits(response.data)
      });
  }, [username])

  return (
  <>
    <Header username={username}/>
    <UIState loading={loading}/>
    <RoutesWrapper username={username} setUsername={setUsername} loading={loading} setLoading={setLoading} notebooks={notebooks} setNotebooks={setNotebooks} reminders={reminders} setReminders={setReminders} postits={postits} setPostits={setPostits}/>
  </>);
}

const RoutesWrapper = (props) => {
  return useRoutes([
    {path:"/login", element: <LoginPage {...props}/>},
    {path:"/signup", element: <SignUp {...props}/>},
    {path:"/reminder/add", element: props.username? <AddReminder {...props}/> : <Navigate to="/login"/>},
    {path:"/postit/add", element: props.username? <AddPostit {...props}/> : <Navigate to="/login"/>},
    {path:"/", element: props.username? <Dashboard {...props}/> : <Navigate to="/login"/>},
  ]);
}

export default App;
