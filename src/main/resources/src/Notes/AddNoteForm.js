import React from 'react';

class AddNoteForm extends React.Component {
    render() {
        console.log("in addnoteform")
        return (
            <div>
                <div className="create-form">
                    <div className="backdrop"></div>
                    <form onSubmit={this.handleSubmit} className="create-note">
                        <input
                            type="text"
                            name="title"
                            placeholder="Title"/>
                        <textarea name="content"
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

export default AddNoteForm;