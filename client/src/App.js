import './App.css';
import FormNewItem from './layouts/formNewItem/FormNewItem';
import TableView from './layouts/tableView/TableView';
import React, { useState, useEffect} from 'react';
import axios from 'axios';


const App = () => {

  const [items, setItems] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/reminders')
      .then(
        res => {
          const data = [];
          res.data.forEach(element => {
            data.push({
              id: element.id,
              title: element.title,
              description: element.description,
              remind: element.remind
            })
          })
          setItems(data);
        }
      )
  }, []);

const appendNote = (title, date) => {
  const length = items.length;
  
  let currentId = 0;

  if (length === 0) {
    currentId = 1;
  } else {
    currentId = items[items.length - 1].id + 1;
  }

  const temp = {id: currentId, title: title, date: date};
  setItems([...items, temp]);
}

const removeNote = (id) => {
  const url = 'http://localhost:8080/api/reminders/delete/${id}';
  axios.get(url);
  setItems(items.filter(item => item.id !== id ));
}

  return (
    <div className='container mt-5'>
      <div className='card'>
        <div className='card-header'>
          <h1>Список напоминаний</h1>
        </div>
        <div className='card-body'>
          <TableView data={items} removeNote={removeNote} />
          <FormNewItem appendNote={appendNote}/>
        </div>
      </div>
    </div>
  );
}

export default App;