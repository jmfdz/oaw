/*******************************************************************************
* Copyright (C) 2017 MINHAFP, Ministerio de Hacienda y Función Pública, 
* This program is licensed and may be used, modified and redistributed under the terms
* of the European Public License (EUPL), either version 1.2 or (at your option) any later 
* version as soon as they are approved by the European Commission.
* Unless required by applicable law or agreed to in writing, software distributed under the 
* License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF 
* ANY KIND, either express or implied. See the License for the specific language governing 
* permissions and more details.
* You should have received a copy of the EUPL1.2 license along with this program; if not, 
* you may find it at http://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32017D0863
******************************************************************************/
package es.gob.oaw.css.checks;

import com.helger.css.ECSSVersion;
import com.helger.css.decl.CSSDeclaration;
import com.helger.css.decl.CascadingStyleSheet;
import com.helger.css.decl.visit.CSSVisitor;
import com.helger.css.reader.CSSReader;
import com.helger.css.reader.errorhandler.CollectingCSSParseErrorHandler;
import com.helger.css.writer.CSSWriterSettings;

import es.gob.oaw.css.CSSProblem;
import es.gob.oaw.css.CSSResource;
import es.gob.oaw.css.OAWCSSVisitor;
import es.gob.oaw.css.utils.CSSSACUtils;
import es.inteco.common.logging.Logger;
import org.dom4j.Document;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Clase que comprueba si se genera contenido de cierta longitud mediante las
 * pseudo clases :before o :after
 */
public class CSSGeneratedContentDocumentHandler extends OAWCSSVisitor {

	private static final String CONTENT_PROPERTY = "content";

	private final int allowedChars;

	public CSSGeneratedContentDocumentHandler(final int allowedChars) {
		this.allowedChars = allowedChars;
	}

	@Override
	public List<CSSProblem> evaluate(final Document document, final CSSResource cssResource) {
		if (!cssResource.getContent().isEmpty() && !cssResource.isInline()) {
			try {
				resource = cssResource;
				final CascadingStyleSheet aCSS = CSSReader.readFromString(cssResource.getContent(), ECSSVersion.CSS30,
						new CollectingCSSParseErrorHandler());
				if (aCSS != null) {
					CSSVisitor.visitCSS(aCSS, this);
				}
			} catch (Exception e) {
				Logger.putLog("Error al intentar parsear el CSS", OAWCSSVisitor.class, Logger.LOG_LEVEL_INFO);
			}
		}
		return problems;
	}

	@Override
	public void onDeclaration(@Nonnull final CSSDeclaration cssDeclaration) {
		if (isValidMedia() && isPseudoClass() && CONTENT_PROPERTY.equals(cssDeclaration.getProperty())) {
			final String value = CSSSACUtils.parseLexicalValue(getValue(cssDeclaration));
			if (cssValueGenerateContent(value)) {
				if (value.length() > allowedChars && value.length() != 5 && !value.startsWith("\\")) {
					getProblems().add(createCSSProblem("", cssDeclaration));
				}
			}
		}

	}

	private boolean cssValueGenerateContent(final String cssValue) {
		if (cssValue == null || cssValue.trim().isEmpty()) {
			return false;
		} else {
			final String loweredCaseValue = cssValue.toLowerCase();
			if ("none".equals(loweredCaseValue)) {
				return false;
			} else if ("open-quote".equals(loweredCaseValue) || "close-quote".equals(loweredCaseValue)
					|| "no-open-quote".equals(loweredCaseValue) || "no-close-quote".equals(loweredCaseValue)) {
				return false;
			} else if (loweredCaseValue.startsWith("url")) {
				return false;
			} else if (loweredCaseValue.startsWith("counter")) {
				return false;
			} else if (loweredCaseValue.startsWith("leader")) {
				return false;
			}
			return true;
		}
	}

	private boolean isPseudoClass() {
		final String selector = currentStyleRule.getSelectorsAsCSSString(new CSSWriterSettings(ECSSVersion.CSS30), 0);
		return selector.contains(":before") || selector.contains(":after");
	}

}
