import React from 'react';

class NoteForm extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            titleFieldVisible: false,
            title: '',
            content: ''
        }
    }

    handleSubmit = () => {
        if (this.state.title || this.state.content) {
            this.setState({
                title: '',
                content: '',
                titleFieldVisible: false
            })
        }
    }

    hideTitleField = () => {
        this.setState({
            titleFieldVisible: false
        })
    }

    showTitleField = () => {
        this.setState({
            titleFieldVisible: true
        })
    }

    render() {
        return (
            <div>
                <div className="create-form">
                    {this.state.titleFieldVisible && (
                        <div className="backdrop" onClick={this.hideTitleField}>
                        </div>
                    )}

                    <form onSubmit={this.handleSubmit} className="create-note">
                        {this.state.titleFieldVisible && (
                            <input
                                type="text"
                                value={this.state.title}
                                onChange={notes => this.setState({title: notes.target.value})}
                                onFocus={this.showTitleField}
                                name="title"
                                placeholder="Title"/>
                        )}
                        <textarea
                            value={this.state.content}
                            onChange={content => this.setState({content: content.target.value})}
                            onFocus={this.showTitleField}
                            name="content"
                            placeholder="Take a note"
                        />
                        <button type="Submit">
                            <span>&#43;</span>
                        </button>
                    </form>
                </div>
            </div>
        )
    }
}

export default NoteForm;