import React from 'react';
import {useNavigate} from 'react-router-dom';
import TextInput from '../components/TextInput';
import api from '../services/api';

export const AddPostit = ({postits, setPostits}) => {
    // const [error, setError] = useState();
    let navigate = useNavigate();
    function handleSubmit(event){
        event.preventDefault();
        let formData = new FormData(event.currentTarget);
        const title = formData.get('title');
        //isso se chama pressa:
        const dueDate = JSON.parse(JSON.stringify(new Date((new Date()).getTime() + 86400000)));
        const notebook = formData.get('notebook');
        const description = formData.get('description');
        console.log({title, dueDate, notebook, description});
        api.post('/postIt', {title, dueDate, notebook, description}).then(res => {
            res?.data && setPostits([res.data, ...postits])
            goToPreviousPath();
        });
    }
    const goToPreviousPath = () => {
        navigate(-1);
    }
    return <div style={container}>
        <h2>New Post-It</h2>
        <form onSubmit={handleSubmit}>
            <div style={{display: 'flex', flexFlow: 'row nowrap', width: '100%', justifyContent: 'space-between'}}>
                <TextInput
                    name={'title'}
                    label={'Title'}
                    type={'text'}
                    style={{width: '47%'}}
                />
                <TextInput
                    name={'notebook'}
                    label={'Notebook (Opcional)'}
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
                <button type={'button'} onClick={goToPreviousPath}>
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