import React from "react";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import About from "./pages/About";
import Quiz from "./pages/Quiz";

function App() {
  return (
    <Router>
      <div style={{ display: "flex", height: "100vh", fontFamily: "Arial, sans-serif" }}>
        {/* Sidebar Navigation */}
        <nav
          style={{
            width: "220px",
            background: "#f8fafc", // dark blue-gray
            color: "white",
            padding: "20px",
            display: "flex",
            flexDirection: "column",
            justifyContent: "space-between",
          }}
        >
          <div>
            <h2 style={{ color: "#1e293b", marginBottom: "30px" }}>GoandLearn</h2>
            <ul style={{ listStyle: "none", padding: 0 }}>
              <li style={{ marginBottom: "15px" }}>
                <Link to="/" style={{ color: "#1e293b", textDecoration: "none" }}>Home</Link>
              </li>
              <li style={{ marginBottom: "15px" }}>
                <Link to="/about" style={{ color: "#1e293b", textDecoration: "none" }}>About</Link>
              </li>
              <li>
                <Link to="/quiz" style={{ color: "#1e293b", textDecoration: "none" }}>Quiz</Link>
              </li>
            </ul>
          </div>
          <p style={{ fontSize: "12px", color: "#94a3b8" }}>© 2025 GoandLearn</p>
        </nav>

        {/* Main Page Area */}
        <main
          style={{
            flexGrow: 1,
            background: "#f8fafc", // light gray background
            overflow: "hidden",
          }}
        >
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/about" element={<About />} />
            <Route path="/quiz" element={<Quiz />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;