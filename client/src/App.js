
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

import Home from './components/Home';
import NavBar from './components/NavBar';
import Garden from './containers/Garden';

function App() {
  return (
    <Router>
      <NavBar />
      <Routes>
        <Route exact path="/" element={< Home />} />
        <Route exact path="/garden" element={< Garden />} />
      </Routes>
    </Router>
  );
}

export default App;
