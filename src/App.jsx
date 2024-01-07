import './App.css';
import AppRouter from './AppRouter';
import { Provider } from 'react-redux';
import { Banco } from './redux/store';

function App() {

  return (
    <Provider store={Banco}>
      <AppRouter />
    </Provider>
  )
}

export default App
