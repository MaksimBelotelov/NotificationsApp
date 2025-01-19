import React, { useState } from "react";

const FormNewItem = (props) => {

    const [title, setTitle] = useState('');
    const [date, setDate] = useState('');

    const submit = () => {
        if (title.trim() === '' || date.trim() === '') return;

        props.appendNote(title, date);
        setTitle('');
        setDate('');
    }

    return (
        <div className='mt-3'>
            <form>
                <div className='mb-3'>
                    <label className='form-label'>Заголовок</label>
                    <input className='form-control' 
                           type='text'
                           value={title}
                           onChange={(e) => {setTitle(e.target.value);}} />
                </div>
                <div className='mb-3'>
                    <label className='form-label'>Время напоминания</label>
                    <input className='form-control' 
                           type='datetime-local' 
                           value={date}
                           onChange={(e) => {setDate(e.target.value);}}/>
                </div>
                <div>
                    <button type='button' 
                            className='btn btn-primary' 
                            onClick={submit}>
                        Новая заметка
                    </button>
                </div>
            </form>
        </div>
    );
}

export default FormNewItem;