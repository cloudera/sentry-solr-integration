/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.sentry.provider.db.service.thrift;

import org.apache.hadoop.minikdc.MiniKdc;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("SENTRY-515: Not part of automated unit testing, as it takes too long")
public class TestConnectionWithTicketTimeout extends
    org.apache.sentry.service.thrift.SentryServiceIntegrationBase {


  @Override
  public void beforeSetup() throws Exception {
    kdcConfOverlay.setProperty(MiniKdc.MAX_TICKET_LIFETIME, "300001");
  }

  /***
   * Test is run only when sentry.hive.test.ticket.timeout is set to "true"
   * @throws Exception
   */
  @Test
  public void testConnectionAfterTicketTimeout() throws Exception {
    Thread.sleep(400000);
    connectToSentryService();
  }

}
