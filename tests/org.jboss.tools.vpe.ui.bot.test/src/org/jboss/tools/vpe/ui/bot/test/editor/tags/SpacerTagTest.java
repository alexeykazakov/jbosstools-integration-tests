/*******************************************************************************
 * Copyright (c) 2007-2016 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.vpe.ui.bot.test.editor.tags;

import org.jboss.reddeer.common.wait.AbstractWait;
import org.jboss.reddeer.common.wait.TimePeriod;

/**
 * Tests Rich Faces Spacer Tag behavior
 * 
 * @author vlado pakan
 *
 */
public class SpacerTagTest extends AbstractTagTest {
	private static final String SPACER_STYLE = "background-color: red;";

	@Override
	protected void initTestPage() {
		initTestPage(TestPageType.XHTML,
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
						+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"\n"
						+ "  xmlns:ui=\"http://java.sun.com/jsf/facelets\"\n"
						+ "  xmlns:f=\"http://java.sun.com/jsf/core\"\n"
						+ "  xmlns:rich=\"http://richfaces.org/rich\"\n"
						+ "  xmlns:h=\"http://java.sun.com/jsf/html\">\n" + "<head>\n" + "</head>\n" + "<body>\n"
						+ "  <f:view>\n" + "    <rich:spacer style=\"" + SpacerTagTest.SPACER_STYLE + "\"/>\n"
						+ "  </f:view>\n" + "  </body>\n" + "</html>");
	}

	@Override
	protected void verifyTag() {
		assertVisualEditorContains(getVisualEditor(), "IMG", new String[] { "width", "height", "class", "style" },
				new String[] { "1px", "1px", "rich-spacer", SpacerTagTest.SPACER_STYLE }, getTestPageFileName());
		// check tag selection
		getVisualEditor().selectDomNode(getVisualEditor().getDomNodeByTagName("IMG", 0), 0);
		AbstractWait.sleep(TimePeriod.getCustom(3));
		String selectedText = getSourceEditor().getSelectedText();
		String hasToStartWith = "<rich:spacer";
		assertTrue("Selected text in Source Pane has to start with '" + hasToStartWith + "'" + "\nbut it is '"
				+ selectedText + "'", selectedText.trim().startsWith(hasToStartWith));
		String hasEndWith = SpacerTagTest.SPACER_STYLE + "\"/>";
		assertTrue("Selected text in Source Pane has to end with '" + hasEndWith + "'" + "\nbut it is '" + selectedText
				+ "'", selectedText.trim().endsWith(hasEndWith));
	}

}
