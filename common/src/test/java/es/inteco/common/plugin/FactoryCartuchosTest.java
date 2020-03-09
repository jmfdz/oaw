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
package es.inteco.common.plugin;

import es.inteco.plugin.FactoryCartuchos;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 */
public class FactoryCartuchosTest {

    @Test
    public void testGetCartuchoNoExists() {
        Assert.assertNull(FactoryCartuchos.getCartucho("no_existe"));
    }

    @Test
    public void testGetCartuchoExists() {
        Assert.assertNotNull(FactoryCartuchos.getCartucho("es.inteco.common.plugin.MockCartucho"));
    }

}
