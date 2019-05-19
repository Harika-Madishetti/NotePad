import React from 'react';
import renderer from "react-test-renderer";
import NoteForm from "./NoteForm";

test('Renders NoteForm',() =>{
    const component = renderer.create(
        <NoteForm/> ,);
    let Form = component.toJSON();
    expect(Form).toMatchSnapshot();
});