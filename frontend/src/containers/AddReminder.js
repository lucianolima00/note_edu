import React from 'react';
import {useNavigate} from 'react-router-dom';
import TextInput from '../components/TextInput';
import api from '../services/api';

export const AddReminder = ({reminders, setReminders}) => {
    // const [error, setError] = useState();
    let navigate = useNavigate();
    function handleSubmit(event){
        event.preventDefault();
        let formData = new FormData(event.currentTarget);
        const title = formData.get('title');
        const dueDate = formData.get('dueDate') + "T00:00:00.000";
        const notebook = formData.get('notebook');
        const description = formData.get('description');
        console.log({title, dueDate, notebook, description});
        api.post('/reminder', {title, dueDate, notebook, description}).then(res => {
            res?.data && setReminders([res.data, ...reminders])
            goToPreviousPath();
        });
    }
    const goToPreviousPath = () => {
        navigate(-1);
    }
    return <div style={container}>
        <h2>New Reminder</h2>
        <form onSubmit={handleSubmit}>
            <TextInput
                name={'title'}
                label={'Title'}
                type={'text'}
            />
            <div style={{display: 'flex', flexFlow: 'row nowrap', width: '100%', justifyContent: 'space-between'}}>
                <TextInput
                    name={'dueDate'}
                    label={'Due Date'}
                    type={'text'}
                    style={{width: '47%'}}
                    placeholder={"aaaa-mm-dd"}
                    />
                <TextInput
                    name={'notebook'}
                    label={'Notebook'}
                    type={'text'}
                    style={{width: '47%'}}
                />
            </div>
            <TextInput
                name={'description'}
                label={'Description'}
                type={'textarea'}
            />
            <div style={buttonRow}>
                <button type={"button"} onClick = {goToPreviousPath}>
                    BACK
                </button>
                <button className={'primary'} type={'submit'}>
                    SUBMIT
                </button>
            </div>
        </form>
    </div>;
};

const buttonRow = {
    display: 'flex', 
    flexFlow: 'row nowrap', 
    width: '100%',
    justifyContent: 'center',
    marginTop: '12px'
}

const container = {
    width: '100%',
    maxWidth: '720px',
    margin: '32px',
    padding: '32px',
    marginLeft: 'auto',
    marginRight: 'auto',
    border: '4px solid #666',
    borderRadius: '24px',
    textAlign: 'center',
}