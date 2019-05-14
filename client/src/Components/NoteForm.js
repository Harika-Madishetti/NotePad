import React from 'react';

class NoteForm extends React.Component {

    render() {
        return (
            <div>
                <div className="create-form">
                    {this.props.titleFieldVisible && (
                        <div className="backdrop" onClick={this.props.hideTitleField}>
                        </div>
                    )}

                    <form onSubmit={this.props.handleSubmit} className="create-note">
                        {this.props.titleFieldVisible && (
                            <input
                                name="title"
                                type="text"
                                value={this.props.title}
                                onChange={this.props.handleChange}
                                onFocus={this.props.showTitleField}
                                placeholder="Title"/>
                        )}
                        <textarea
                            name="content"
                            value={this.props.content}
                            onChange={this.props.handleChange}
                            onFocus={this.props.showTitleField}
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