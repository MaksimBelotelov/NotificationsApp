import './App.css';

function App() {
  return (
    <div className='container mt-5'>
      <div className='card'>
        <div className='card-header'>
          <h1>Список напоминаний</h1>
        </div>
        <div className='card-body'>
          <table className='table table-hover'>
            <thead>
              <tr>
                <th scope='col'>Id</th>
                <th scope='col'>Title</th>
                <th scope='col'>Напоминание</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope='row'>1</th>
                <th scope='col'>Заголовок 1</th>
                <th scope='col'>01.01.2026 12:00</th>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default App;