import React, { Component } from 'react';

class Quiz extends Component {
    constructor(props) {
        super(props);
        // Questions array
        this.questions = [
            {
                question: "Question 1",
                answers: ["Answer 1", "Answer 2", "Answer 3"],
                correct: "Answer 1",
            },
            {
                question: "Question 2",
                answers: ["Answer A", "Answer B", "Answer C"],
                correct: "Answer B",
            },
        ];

        this.state = {
            currentIndex: 0,
            message: this.questions[0].question,
        };

        this.handleClick = this.handleClick.bind(this);
        this.handleNextClick = this.handleNextClick.bind(this);
    }

    handleClick(answer) {
        const correctAnswer = this.questions[this.state.currentIndex].correct;
        this.setState({
            message: `You answered: ${answer}\nThe correct answer is: ${correctAnswer}`,
        });
    }

    handleNextClick() {
        const nextIndex = this.state.currentIndex + 1;
        if (nextIndex < this.questions.length) {
            this.setState({
                currentIndex: nextIndex,
                message: this.questions[nextIndex].question,
            });
        } else {
            this.setState({
                message: "Quiz finished! 🎉",
            });
        }
    }

    render() {
        const { currentIndex, message } = this.state;
        const currentAnswers = this.questions[currentIndex]?.answers || [];

        return (
            <div style={{ padding: '20px' }}>
                <h1>Test your knowledge</h1>
                <h2 style={{ whiteSpace: 'pre-line' }}>{message}</h2>

                <div style={{ display: 'flex', gap: '10px', marginTop: '20px' }}>
                    {currentAnswers.map((answer, index) => (
                        <button
                            key={index}
                            onClick={() => this.handleClick(answer)}
                            style={{
                                padding: '10px 20px',
                                borderRadius: '12px',
                                border: 'none',
                                backgroundColor: '#38bdf8',
                                color: 'white',
                                cursor: 'pointer',
                            }}
                        >
                            {answer}
                        </button>
                    ))}
                    <button
                        onClick={this.handleNextClick}
                        style={{
                            padding: '10px 20px',
                            borderRadius: '12px',
                            border: 'none',
                            backgroundColor: '#10b981',
                            color: 'white',
                            cursor: 'pointer',
                        }}
                    >
                        Next
                    </button>
                </div>
            </div>
        );
    }
}

export default Quiz;
