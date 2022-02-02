import React, {useState, useEffect} from 'react';
// import logo from './logo.svg';
// import './App.css';
import LoginPage from './containers/LoginPage';
import { useRoutes } from 'react-router-dom';
import Dashboard from './containers/Dashboard';
import UIState from './components/UIState';
import Header from './components/Header';
import { getNotebooks, getPostits, getReminders } from './api';

function App() {
  const [username, setUsername] = useState("");
  const [loading, setLoading] = useState(false);
  const [notebooks, setNotebooks] = useState([]);
  const [reminders, setReminders] = useState([]);
  const [postits, setPostits] = useState([]);

  useEffect(() => {
    getNotebooks(username, setNotebooks)
    getReminders(username, setReminders)
    getPostits(username, setPostits)
    return () => {
     
    }
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
    {path:"/", element: <Dashboard {...props}/>},
    {path:"/login", element: <LoginPage {...props}/>}
  ]);
}

export default App;
