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

/**
 * Tests Summary Tag behavior 
 * @author vlado pakan
 *
 */
public class SummaryTagTest extends AbstractTagTest{
  private static String SUMMARY_TEXT = "!@#$ Summary text $#@!";
  @Override
  protected void initTestPage() {
    initTestPage(TestPageType.HTML,
        "<!DOCTYPE html>\n" +
        "<html>\n" +
        "  <head>\n" +
        "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
        "    <title>Insert title here</title>\n" +
        "  </head>\n" +
        "  <body>\n" +
        "    <summary>" + SummaryTagTest.SUMMARY_TEXT + "</summary>\n" +
        "  </body>\n" +
        "</html>\n");
  }

  @Override
  protected void verifyTag() {
    // check Problems View for Errors
    assertProbelmsViewNoErrorsForPage();
    // visual representation contains SUMMARY tag
    assertVisualEditorContains(getVisualEditor(), "SUMMARY", null, null, getTestPageFileName());
    // visual representation contains SUMMARY_TEXT text
    assertVisualEditorContainsNodeWithValue(getVisualEditor(), 
        SummaryTagTest.SUMMARY_TEXT, getTestPageFileName());
  }

}
