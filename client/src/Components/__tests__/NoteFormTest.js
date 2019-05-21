import React from 'react';
import { shallow, mount } from 'enzyme';
import NoteForm from '../NoteForm'

describe("Noteform component", () => {
    const component = shallow(<NoteForm/>)
    it("should render the NoteForm Component", () => {
        expect(component.getElement()).toMatchSnapshot();
    })
    it("should handle click event",() => {
        const output = shallow(<NoteForm titleFieldVisible="mockTitleFieldVisible"/>)
        output.simulate('click');
        expect(output.state().titleFieldVisible).toEqual(true)
    })
})