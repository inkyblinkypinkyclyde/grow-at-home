
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Home from './components/Home';
import NavBar from './components/NavBar';
import AllGardens from './containers/AllGardens';

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route exact path="/" element={< Home />} />
        <Route exact path="/garden" element={< AllGardens />} />
      </Routes>
    </Router>
  );
}

export default App;
