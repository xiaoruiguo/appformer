/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.livespark.formmodeler.renderer.backend.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.livespark.formmodeler.model.FieldDefinition;
import org.livespark.formmodeler.model.FormDefinition;
import org.livespark.formmodeler.model.impl.basic.datePicker.DatePickerFieldDefinition;
import org.livespark.formmodeler.model.impl.basic.selectors.listBox.EnumListBoxFieldDefinition;
import org.livespark.formmodeler.model.impl.basic.textBox.TextBoxFieldDefinition;
import org.livespark.formmodeler.renderer.test.model.Person;
import org.livespark.formmodeler.renderer.test.model.Title;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BasicModel2FormTransformerServiceTest extends AbstractModel2FormTransformerServiceTest<Person> {

    @Before
    @Override
    public void init() {
        super.init();
    }

    @Test
    public void testCreateContextForBasicModel() {
        initTest( new Person(), 4 );

        FormDefinition form = context.getRootForm();

        checkTitleField(  form.getFieldById( "title" ) );
        checkSurname(  form.getFieldById( "surname" ) );
        checkBirthday(  form.getFieldById( "birthday" ) );

    }

    protected void checkTitleField( FieldDefinition field ) {
        assertNotNull( field );
        assertTrue( field instanceof EnumListBoxFieldDefinition );
        assertEquals( Title.class.getName(), field.getFieldTypeInfo().getType() );
        assertTrue( field.getFieldTypeInfo().isEnum() );
    }

    protected void checkSurname( FieldDefinition field ) {
        assertNotNull( field );
        assertTrue( field instanceof TextBoxFieldDefinition );
    }

    protected void checkBirthday( FieldDefinition field ) {
        assertNotNull( field );
        assertTrue( field instanceof DatePickerFieldDefinition );
    }
}