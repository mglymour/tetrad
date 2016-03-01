/*
 * Copyright (C) 2016 University of Pittsburgh.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package edu.cmu.tetrad.cli;

/**
 *
 * Jan 27, 2016 5:02:16 PM
 *
 * @author Kevin V. Bui (kvb2@pitt.edu)
 */
public interface SimulatedDatasets {

    public static final String[] SIM_20VARS_100CASES = {
        "X0\tX1\tX2\tX3\tX4\tX5\tX6\tX7\tX8\tX9\tX10\tX11\tX12\tX13\tX14\tX15\tX16\tX17\tX18\tX19",
        "2.4475\t0.5148\t2.5901\t-0.0721\t1.4016\t0.0888\t-7.9602\t1.1406\t4.4783\t1.8136\t-1.9697\t1.8451\t2.7634\t4.5470\t8.3919\t-1.8954\t-1.6719\t-1.9283\t0.3101\t4.7454",
        "-0.8261\t0.0612\t-3.6800\t4.0955\t1.2874\t-0.8010\t4.1415\t-0.7477\t-0.5047\t0.6948\t0.5274\t-1.0396\t0.5155\t0.7066\t-6.6644\t-0.3088\t2.0915\t-7.3785\t-5.5573\t2.3495",
        "0.2292\t-1.4067\t0.1086\t3.1234\t-0.6666\t-0.5165\t3.4851\t1.2906\t1.1263\t0.3555\t-0.8132\t1.4814\t2.0138\t-0.2333\t-2.7676\t0.4278\t4.8446\t-5.0355\t-2.1781\t-0.0119",
        "1.9147\t0.0218\t2.3734\t3.4512\t1.2840\t-1.2361\t-4.5019\t1.0082\t3.0217\t1.8572\t-1.8176\t1.5891\t5.4796\t-3.6909\t-8.8024\t-1.2090\t-0.5565\t-7.9374\t-4.9817\t3.5984",
        "2.1585\t2.0749\t-0.5698\t0.9008\t3.7927\t-2.1687\t-1.0944\t-3.5404\t0.0533\t3.3814\t0.6656\t-0.4686\t-1.1260\t-3.7211\t1.2758\t-1.7773\t-2.5852\t-8.4607\t0.4123\t7.7740",
        "0.5168\t-0.5694\t-0.2519\t-0.8110\t-1.7504\t2.2543\t0.6082\t-2.1273\t-0.3188\t0.1038\t2.0059\t-0.7415\t2.8601\t0.1616\t4.8135\t-2.0575\t0.9822\t2.0738\t1.7646\t1.6173",
        "1.2596\t-1.9587\t1.6036\t0.1512\t2.8354\t2.8037\t-0.1661\t-0.7514\t1.2414\t2.6244\t-0.1229\t1.3054\t1.8161\t-0.6625\t1.4514\t-1.6441\t2.9337\t1.1537\t1.3006\t2.7851",
        "2.2545\t-1.7264\t-4.2746\t1.7404\t1.0999\t1.8959\t3.4948\t-1.7983\t-3.5832\t1.2714\t1.5188\t-0.0925\t1.1256\t-5.5139\t-5.3072\t2.1112\t0.5733\t-2.4176\t0.1910\t2.2937",
        "2.5974\t-2.6567\t-0.8007\t-0.6040\t-0.4938\t1.1526\t4.3406\t0.2634\t-1.0870\t0.2131\t-2.6082\t-0.2377\t-0.8496\t-2.0886\t4.6698\t-1.4620\t2.8557\t1.7209\t2.2693\t-0.0082",
        "4.0817\t1.2652\t-0.3697\t2.6089\t4.6733\t-0.3017\t-0.3998\t-0.7225\t-0.6851\t3.8808\t-3.7962\t2.0703\t-0.7818\t-3.3961\t-5.0248\t-1.9683\t-0.3097\t-8.8967\t-2.1071\t6.7364",
        "4.2934\t-1.7388\t3.6440\t1.6619\t6.2376\t0.8850\t-8.0750\t2.4532\t5.1044\t3.7672\t-0.5629\t0.2177\t5.7758\t-2.2899\t-5.2073\t1.3979\t-1.0698\t-2.3780\t-2.0507\t4.4886",
        "0.2482\t0.4906\t-0.1887\t1.4454\t-1.2547\t-2.9306\t0.7124\t1.2532\t-0.2168\t-1.0883\t-1.3934\t2.2192\t-0.1549\t-0.8263\t0.6217\t-2.2724\t1.1943\t-3.4099\t-2.0674\t-1.9044",
        "2.9179\t1.2948\t0.3419\t1.6767\t3.8293\t3.5430\t3.6420\t-0.9043\t-1.0139\t3.0971\t-1.3892\t-1.3544\t0.3911\t-2.4326\t-3.7197\t-0.5909\t0.5564\t-2.0705\t-0.5663\t8.4511",
        "2.8987\t-2.5516\t3.0141\t-1.0512\t3.8520\t0.8765\t-0.1814\t3.8657\t4.4168\t3.4178\t-0.1180\t0.8822\t1.6017\t1.1801\t5.3376\t-0.1859\t5.9990\t-2.2499\t2.2234\t1.8563",
        "-1.1119\t-1.5893\t1.3631\t2.5117\t-1.4975\t-3.7841\t-3.4887\t-0.2593\t3.0309\t-1.6984\t-0.3078\t-1.3621\t1.1668\t-0.6390\t-4.2616\t2.4567\t2.8418\t-6.2019\t-1.8364\t-4.1138",
        "-0.9366\t0.0580\t-1.2384\t2.0350\t-5.3792\t3.2509\t3.1123\t-1.2709\t-1.6082\t-2.5846\t-3.1987\t-1.3165\t-1.4265\t1.7074\t-0.5154\t0.8229\t-0.6591\t0.5071\t-2.1097\t-3.8528",
        "2.6506\t1.6498\t-1.2563\t1.6147\t5.3056\t4.2684\t2.1284\t1.1077\t-1.7831\t4.3837\t0.1451\t-0.3992\t1.4613\t-4.2116\t-6.0423\t1.6512\t-0.5594\t-1.0612\t-1.4046\t8.5562",
        "1.0616\t0.0572\t-6.8795\t0.9058\t1.9479\t1.6712\t4.5561\t-3.3336\t-4.7284\t1.1154\t1.9641\t-1.1081\t-3.6129\t-6.5786\t-7.4592\t0.3375\t-1.4994\t-1.8526\t-2.4531\t4.1859",
        "0.4199\t-2.8658\t0.4329\t-0.4039\t-0.4045\t1.3649\t1.0809\t0.1481\t-1.3748\t-0.9559\t3.6183\t1.3496\t1.9618\t-0.3696\t0.2818\t0.3525\t0.9875\t-0.1738\t-1.2715\t-3.4429",
        "1.2050\t-1.7159\t-0.4386\t3.2930\t0.1358\t-0.4232\t0.6783\t0.7553\t0.7140\t-1.1502\t-1.0096\t0.2395\t1.7842\t-2.9939\t-7.2118\t2.2892\t3.0240\t-4.3969\t-2.5256\t-2.1392",
        "1.5317\t-0.3299\t-0.2760\t0.8921\t1.0164\t-1.6587\t2.4241\t0.8473\t-0.6664\t-0.6358\t0.1193\t0.2547\t0.0113\t2.1424\t-2.6342\t0.4013\t2.1853\t-1.5524\t-1.9927\t-0.2187",
        "-2.3024\t0.6194\t1.0104\t-0.3553\t-1.5746\t0.7354\t-4.0350\t-1.4985\t1.2808\t-1.0172\t1.9200\t0.7418\t1.5386\t-0.9582\t3.2691\t1.2144\t-1.8542\t2.0355\t4.3337\t0.3780",
        "2.0921\t-2.2457\t1.8116\t0.9012\t1.0377\t2.3038\t-0.4859\t0.3136\t0.0538\t0.6599\t0.5348\t-0.7548\t1.3804\t-1.8415\t-2.5517\t3.0824\t-0.3893\t0.3262\t-0.1488\t0.2176",
        "-0.8636\t-0.2439\t-2.0730\t1.4142\t0.0454\t1.9426\t6.7465\t0.1813\t-4.1367\t-0.9562\t0.7058\t-2.6325\t-0.4727\t-1.5548\t-3.6270\t1.1428\t2.5313\t-2.7573\t-1.0343\t1.9485",
        "1.6355\t-1.9667\t0.5765\t2.8718\t3.6648\t0.7473\t0.2060\t1.2069\t1.9853\t2.0676\t-1.9846\t-0.4788\t2.1729\t0.7324\t-2.3395\t-2.8851\t2.4807\t-6.1992\t-5.1651\t1.0423",
        "0.0755\t-0.4904\t1.5176\t-0.0577\t-4.8818\t-0.3586\t3.3279\t0.8487\t2.0046\t-3.2029\t-0.0387\t-1.3990\t0.0056\t4.0297\t8.1024\t-2.6879\t2.8646\t1.6000\t1.0660\t-5.1078",
        "0.7746\t0.5618\t-1.6925\t0.3618\t-2.2900\t2.7415\t5.1482\t0.7254\t-3.3510\t-1.3639\t2.7817\t0.4053\t-2.9274\t-1.1685\t-2.8904\t-0.1195\t-1.1954\t1.9446\t-2.2501\t-1.5918",
        "2.3914\t-0.5030\t-0.7410\t0.6574\t1.8204\t1.5350\t0.2328\t-2.3533\t0.3150\t1.7797\t-1.2065\t-2.2373\t0.5248\t-2.7627\t-0.4959\t-2.2807\t1.6545\t-0.3104\t-0.5741\t4.3134",
        "0.8044\t-1.7096\t1.4422\t2.4030\t-1.1369\t-3.3177\t-3.6865\t1.1678\t3.4983\t-0.6598\t-3.2708\t-0.7528\t5.0916\t0.9454\t-1.6296\t0.8805\t1.9893\t-7.6924\t-1.9952\t-0.7175",
        "-0.6763\t-2.5612\t2.3629\t-1.9771\t-2.8383\t2.6220\t3.6226\t1.4349\t-1.0072\t-1.5071\t0.5220\t-1.8460\t1.3737\t0.2330\t8.7473\t-1.0992\t3.8783\t5.2535\t3.0152\t-1.6194",
        "0.8409\t0.3501\t1.1308\t0.2425\t0.5177\t1.3456\t2.0831\t-1.1045\t1.5812\t1.2542\t-1.9508\t-1.1148\t0.5273\t-1.9085\t4.6715\t-2.1021\t0.4276\t-1.6229\t1.1631\t2.4368",
        "-0.6070\t-2.1694\t2.2846\t-1.2809\t-0.1394\t1.3528\t1.4425\t0.3640\t0.5870\t0.2209\t-0.1323\t-0.3494\t0.0962\t-0.4401\t-0.1865\t0.4022\t1.1855\t0.4865\t2.1879\t-0.0417",
        "0.6439\t-1.5808\t-4.6276\t2.0689\t0.5527\t-0.6429\t3.8518\t1.0461\t-1.1847\t1.1029\t1.2517\t-2.4753\t0.1732\t-2.3727\t-2.0466\t-0.4834\t0.4610\t-3.8333\t-1.6151\t2.2055",
        "2.7797\t-0.4572\t-1.5701\t-1.0543\t0.7028\t-1.7017\t1.3191\t-0.0416\t-0.2795\t0.5251\t-0.4508\t-0.6440\t2.6322\t-2.7746\t1.3007\t2.4372\t-0.5035\t-3.0676\t3.5854\t2.3912",
        "-0.2572\t-0.7279\t-1.0248\t-2.5408\t0.2429\t0.5657\t7.6927\t0.8364\t-4.2916\t0.7870\t2.7810\t-0.9394\t-2.0129\t-5.3083\t2.2763\t-1.0728\t1.8082\t1.9445\t3.1768\t1.6015",
        "0.7578\t0.8810\t2.5254\t1.8923\t3.4391\t-1.1076\t-4.2251\t2.5357\t2.7574\t2.0285\t-1.6381\t1.0511\t1.1949\t1.0157\t0.8135\t0.3887\t-0.2814\t-4.8634\t-1.1518\t3.8934",
        "-0.3693\t2.2174\t0.1315\t-1.0673\t-0.9330\t1.0940\t-3.9261\t0.4521\t1.7584\t-2.7230\t-0.1407\t1.0537\t4.1297\t1.9470\t1.4201\t1.7668\t-0.6298\t4.2087\t0.7232\t-0.4007",
        "2.2084\t-0.4681\t0.5309\t0.3489\t4.3842\t1.7513\t0.6151\t1.0655\t0.6619\t6.0377\t-0.4785\t-0.0696\t2.4417\t-4.4767\t-8.3183\t1.7475\t1.4896\t-2.4827\t-0.5595\t9.2166",
        "-0.1739\t-1.6893\t2.5416\t-0.1759\t-2.4241\t2.4410\t-1.1156\t1.4014\t2.8068\t-2.2350\t-0.6918\t0.1810\t1.6174\t1.1195\t0.8393\t1.2424\t1.5266\t4.0936\t-0.4719\t-3.6294",
        "0.6553\t-1.1950\t0.4422\t2.6171\t3.4499\t-1.3842\t-0.2301\t-0.7643\t0.5075\t1.5766\t-1.0792\t-3.4762\t0.1182\t-3.9408\t-1.2670\t-2.0508\t1.5167\t-3.4432\t-1.8508\t2.8323",
        "0.8325\t-2.5921\t0.6404\t-0.5890\t1.5503\t1.1493\t5.2815\t-0.9080\t-0.8045\t0.0642\t1.7102\t-0.3456\t0.4359\t-1.5804\t1.3908\t-0.0014\t4.7732\t1.0605\t-0.4153\t-1.6345",
        "-0.2103\t-0.7416\t4.1806\t0.7895\t-0.3306\t1.7247\t-4.2063\t2.3750\t2.8245\t-0.0917\t-1.2534\t0.4987\t3.3026\t-1.2096\t-3.0972\t-0.2564\t2.4045\t-0.8084\t-1.2766\t-0.5012",
        "0.8905\t0.3991\t-2.6118\t1.9302\t-1.5810\t1.0617\t4.8951\t-1.6346\t-2.7264\t-0.8695\t0.4863\t1.1699\t-1.6267\t2.1477\t8.2337\t-1.8385\t0.7314\t-2.0499\t2.0242\t0.0514",
        "-0.9339\t-0.6898\t0.8790\t-1.8023\t-1.3460\t0.1721\t6.1549\t-0.8925\t-2.0593\t-2.0431\t-2.8956\t0.4427\t-1.8850\t-1.1046\t3.5203\t-3.2231\t2.7417\t2.8654\t0.8973\t-2.8877",
        "1.3198\t-0.0568\t-1.4067\t2.0197\t4.0330\t1.5136\t-0.6983\t1.2610\t-0.1643\t2.8966\t0.0084\t-0.5599\t0.9720\t-5.7969\t-6.4607\t2.2973\t-0.9795\t-4.8529\t-0.5538\t5.0057",
        "1.9122\t2.6697\t-0.0733\t1.8612\t1.1097\t1.4010\t0.1787\t0.3786\t0.4735\t2.1046\t-0.2623\t-0.6409\t-3.6624\t-2.7689\t-3.1803\t-1.4965\t-0.7645\t-3.0420\t-2.0066\t8.2186",
        "0.5757\t0.7306\t-0.8530\t-0.0104\t-0.8475\t0.4911\t-3.3056\t0.2459\t1.2729\t-0.4492\t0.7740\t-0.1049\t1.3956\t-1.6429\t3.6204\t-1.8112\t0.7714\t-1.1990\t1.5639\t-0.1160",
        "1.2642\t-0.1861\t-1.2334\t4.1091\t1.6861\t1.1061\t-3.8992\t-0.1540\t2.4347\t1.0435\t-0.5559\t-3.4039\t0.7760\t-1.1505\t-2.8299\t-2.2954\t0.4016\t-6.1462\t-3.4459\t3.2258",
        "3.6509\t-1.2284\t0.0588\t1.2582\t3.2853\t5.7573\t2.6423\t1.7226\t0.5746\t4.1479\t-0.9535\t-0.2995\t-0.0405\t-1.4066\t1.0767\t0.6185\t3.1722\t-0.5746\t0.0882\t4.9340",
        "2.0233\t-0.5505\t0.2958\t1.4085\t-0.5798\t0.9373\t0.7121\t0.8096\t1.0026\t-1.5564\t-3.3294\t-1.0154\t2.8876\t1.4277\t0.2850\t1.6827\t1.5442\t-0.1771\t-1.0988\t-1.3096",
        "0.2312\t2.6839\t0.2297\t0.8523\t0.4224\t3.2294\t-4.1428\t-0.2245\t0.6513\t-0.4130\t-1.2187\t-1.8812\t0.4171\t-1.4307\t-6.2277\t1.6149\t-4.1343\t1.1368\t-2.7231\t2.9605",
        "-2.2815\t-1.3124\t3.1030\t-1.1568\t-3.5084\t-1.3484\t0.6591\t3.1242\t0.9170\t-4.2952\t-0.6967\t-0.1992\t3.0259\t5.1578\t3.6910\t0.4219\t1.6163\t2.9335\t-0.0826\t-6.6092",
        "-2.0546\t-0.9269\t-0.6458\t0.4230\t-6.8313\t0.7650\t7.1038\t0.4871\t-3.0521\t-6.1405\t-2.0501\t0.7781\t-2.5098\t5.3018\t0.3887\t1.3289\t1.5900\t2.9527\t-1.6258\t-8.1122",
        "-0.2431\t0.1304\t0.2485\t-0.5592\t-4.2790\t0.0106\t-0.7287\t0.3591\t0.2840\t-3.4765\t-1.6280\t0.6112\t2.4832\t4.6811\t9.8138\t-1.2699\t0.8919\t0.6780\t2.6302\t-6.1251",
        "5.2251\t-1.7110\t-1.3135\t1.7393\t8.3319\t1.4674\t-1.5256\t-0.1003\t1.4450\t7.7236\t0.4396\t0.3339\t0.9197\t-5.4133\t-2.1043\t0.2193\t0.3423\t-8.2265\t1.4392\t11.4168",
        "1.1737\t0.2502\t-1.0696\t1.5781\t-1.1345\t-1.4310\t-1.0875\t0.9829\t0.5294\t-1.5316\t-3.0510\t-1.1776\t-0.0014\t0.2160\t-0.0968\t1.1399\t1.2706\t-2.0374\t-0.8179\t-2.0914",
        "2.8153\t-1.6111\t-1.3506\t-0.5260\t-0.5653\t-1.0475\t2.9775\t-2.1029\t-1.8694\t0.2209\t1.2412\t0.4491\t-0.4973\t0.2510\t3.1618\t0.6602\t2.5785\t-1.8960\t0.4465\t-0.1357",
        "1.0846\t-1.2755\t1.9089\t1.4990\t-0.9984\t0.5272\t-5.3603\t-0.8535\t2.4873\t-1.3322\t-1.5419\t-1.1141\t1.7144\t2.0730\t3.0407\t1.9519\t1.8336\t0.1291\t-0.5794\t-2.9642",
        "1.8066\t-0.3969\t-3.6562\t-0.2832\t1.6054\t0.5715\t3.8171\t2.3625\t-4.3248\t1.7022\t-1.7265\t1.8761\t-4.0742\t-5.3503\t-4.1806\t1.6983\t0.4861\t-2.6142\t0.9534\t3.9786",
        "0.9535\t-1.0894\t1.8698\t2.4837\t2.8191\t-0.3145\t-1.2741\t1.7570\t1.2460\t2.0994\t-1.5571\t0.4767\t-0.2655\t0.8587\t-6.1658\t0.9454\t1.5036\t-3.9114\t-5.1247\t3.6754",
        "-0.3082\t-0.0211\t0.0923\t-1.5642\t1.9561\t2.4841\t1.1801\t0.3613\t-0.6304\t1.3859\t-0.5657\t-0.4424\t0.9545\t-3.4929\t8.0112\t-1.9984\t0.7259\t1.1581\t4.6831\t4.1062",
        "2.0292\t-2.2799\t0.2288\t1.9403\t-0.0404\t2.6968\t1.3355\t0.5389\t0.2032\t0.9432\t-0.6542\t0.1448\t1.3214\t-0.3801\t-2.4233\t0.6782\t4.4015\t-1.0199\t-1.6206\t1.3914",
        "-0.1509\t-3.3245\t1.7004\t-0.7357\t-1.7328\t1.6252\t1.2647\t4.4269\t0.3526\t-1.3134\t-0.7014\t-1.1185\t0.2283\t0.1790\t1.2441\t-1.0053\t1.5886\t4.0556\t0.6991\t-1.1818",
        "1.6110\t-0.5821\t2.4068\t2.0311\t0.5097\t-0.6231\t-1.2580\t1.4168\t3.8220\t1.3094\t0.3591\t-0.8808\t2.5004\t5.5535\t6.0480\t-1.5560\t2.1264\t-2.2661\t-0.5156\t3.9814",
        "0.5334\t1.2651\t0.0844\t2.2327\t0.3424\t1.8597\t-0.0896\t1.1334\t1.0061\t0.9492\t-1.1267\t-1.6198\t2.4880\t0.3017\t2.0556\t0.1532\t-0.6193\t-2.3232\t-0.3074\t3.7661",
        "2.5524\t0.7733\t-0.4328\t-0.1020\t3.7122\t0.1490\t3.3980\t-0.9060\t-4.1390\t3.7224\t-0.0045\t-1.5822\t-5.5670\t-5.3087\t-3.7299\t0.5686\t1.0490\t-0.7074\t1.1060\t6.5105",
        "2.2154\t-0.1846\t0.4073\t0.4294\t-0.1659\t-0.5268\t2.1663\t0.5845\t-0.2130\t0.3217\t1.6200\t1.3409\t-0.0120\t-0.8398\t-0.7494\t1.0561\t0.1020\t-2.5196\t-0.5367\t1.9681",
        "0.3749\t-1.8464\t0.5317\t-1.9853\t-4.1062\t3.0254\t0.2807\t1.4903\t0.6306\t-3.4480\t1.5536\t0.1057\t2.3074\t2.0308\t2.2953\t2.8914\t0.9622\t7.8599\t2.5715\t-4.2071",
        "3.2841\t1.8180\t0.4806\t1.3097\t2.3569\t0.4003\t-1.3229\t-0.1482\t0.2549\t3.0145\t-3.8159\t0.8415\t0.9316\t-2.6632\t3.2185\t-1.4402\t-1.5243\t-3.0824\t4.0015\t5.1993",
        "-1.3616\t0.3457\t-3.2672\t-0.2739\t-3.3125\t1.5779\t8.4952\t0.2283\t-4.1974\t-4.0051\t-2.6399\t1.4525\t-4.0478\t1.6355\t1.3328\t-0.4708\t-0.9331\t4.1466\t-2.4328\t-4.7343",
        "4.3239\t-2.1597\t3.1244\t-0.1881\t2.8861\t1.4790\t0.9866\t4.8809\t0.7018\t3.1752\t-2.7395\t-0.0051\t4.2382\t0.3546\t7.3936\t-2.3132\t0.9476\t-1.4572\t0.6220\t1.7835",
        "1.3463\t1.7423\t2.7436\t-1.1897\t-1.8446\t2.6561\t-0.6409\t0.3080\t1.5986\t-1.3053\t-2.2090\t0.6474\t2.9759\t1.2027\t-0.0615\t2.9283\t-0.7788\t3.7424\t-0.2311\t-1.0123",
        "2.5283\t0.2716\t-1.5867\t1.2707\t1.2667\t1.4691\t0.0046\t0.8197\t-0.3302\t0.8915\t0.3193\t1.4343\t-1.6760\t-0.9379\t-3.7694\t1.3928\t2.3917\t0.3713\t-1.5788\t2.4365",
        "1.8545\t3.0814\t-0.1622\t2.9915\t-0.6657\t1.0738\t-9.0096\t0.1225\t4.7337\t0.3549\t-1.7334\t-0.0970\t3.8681\t0.5885\t-2.9449\t-1.3959\t-2.2809\t-4.1934\t-3.5288\t2.3440",
        "0.8074\t0.4546\t1.1418\t0.7782\t-0.0251\t2.6750\t-3.1544\t-0.9442\t2.6440\t0.9370\t-2.0862\t-1.0453\t1.9046\t-2.0594\t2.2407\t-2.0563\t0.2648\t1.5155\t0.7075\t2.8266",
        "0.1151\t-1.4043\t1.7932\t0.3225\t-3.9618\t-0.3319\t3.9457\t0.1494\t0.4761\t-3.9539\t0.1065\t-0.9607\t-1.5116\t2.6982\t6.3397\t-2.4962\t3.0244\t1.3016\t1.5632\t-5.1783",
        "1.6417\t-2.4861\t0.0021\t1.3190\t3.5571\t1.1044\t-3.0739\t1.0272\t-0.1164\t2.3699\t-1.8387\t-1.0419\t-0.7962\t-1.8710\t-1.0774\t1.6823\t0.9990\t-2.3686\t0.5367\t3.5426",
        "2.9061\t-0.3892\t0.2641\t-0.6624\t0.2810\t2.7214\t2.2548\t0.8492\t0.3276\t0.6711\t-2.2627\t1.1615\t2.4218\t-2.4531\t2.3278\t0.9026\t1.2400\t3.8978\t2.1902\t2.6461",
        "1.2637\t1.1500\t-2.6028\t0.2177\t2.8143\t1.3816\t3.4137\t-2.0078\t-1.7600\t3.2665\t-1.7018\t-0.9770\t-2.0093\t-2.9083\t-3.5894\t-0.4581\t-0.4799\t-1.1321\t-0.4652\t6.0287",
        "-2.5917\t0.2817\t-0.8595\t2.2290\t-6.2997\t2.3772\t-0.5076\t-0.4028\t0.1375\t-5.7381\t-5.0366\t1.0155\t0.2037\t6.1389\t-0.9872\t2.1171\t-1.2472\t3.0213\t-4.4681\t-6.6417",
        "-0.4888\t-2.9672\t-0.7130\t2.4359\t-2.5752\t1.5424\t-0.4010\t0.7308\t0.4128\t-2.0640\t-2.6181\t-0.5952\t2.4228\t-2.2230\t-1.3499\t-1.2336\t2.0119\t-0.2697\t-1.2900\t-3.5220",
        "0.3328\t1.5121\t2.6296\t-0.9626\t0.5200\t5.0739\t-2.5948\t0.5604\t2.3917\t0.6725\t-3.7971\t1.4365\t1.4773\t2.1887\t7.5375\t-0.4257\t-1.1831\t3.7736\t3.5739\t4.0653",
        "2.9204\t0.9746\t0.7452\t1.6172\t3.6091\t-1.7590\t-0.3315\t2.4437\t-0.4283\t2.8694\t-1.3340\t-0.1776\t-0.7071\t-4.1941\t-3.6185\t2.1702\t1.5293\t-6.0113\t0.1770\t6.4824",
        "-0.3308\t-0.1153\t1.1079\t1.4290\t-0.7125\t1.5681\t-2.2819\t-0.2728\t0.5188\t-1.7304\t-0.7631\t1.4098\t1.6454\t3.5467\t3.4344\t-2.4539\t0.8194\t-0.9961\t-1.4795\t0.0123",
        "1.4871\t-0.8570\t2.8789\t1.6469\t3.0447\t3.4591\t-2.4923\t2.2951\t3.8291\t1.9053\t-1.4180\t-0.7375\t1.7182\t0.1076\t-2.1231\t0.7552\t1.8127\t2.1310\t-1.6106\t4.1432",
        "0.0055\t2.9826\t0.7090\t-0.6654\t0.0379\t-0.6384\t-1.6556\t1.7642\t0.9926\t-0.9529\t-0.5132\t-0.1749\t0.9300\t0.8178\t9.2045\t-1.0377\t-1.5158\t-0.5508\t4.5654\t1.1158",
        "2.3902\t-1.2448\t2.5911\t0.0486\t4.3791\t0.8783\t-2.1351\t0.2384\t2.1421\t5.4463\t0.0143\t-0.4862\t1.4041\t-4.7752\t1.7838\t-3.2197\t0.5348\t-2.2806\t1.5181\t7.5271",
        "1.2140\t-2.6516\t4.1514\t-0.0201\t1.4209\t1.3521\t-6.7655\t-0.6342\t5.4545\t0.7298\t1.0452\t-1.3513\t7.4328\t1.7019\t4.2348\t0.9397\t3.4361\t-1.5155\t1.4892\t0.5636",
        "1.8245\t-0.5152\t-0.0908\t0.1651\t1.7199\t-0.2792\t-3.0173\t-0.2062\t0.8712\t0.7739\t-0.1366\t-0.0160\t1.0135\t-1.4954\t0.4661\t0.6152\t0.0069\t-1.4145\t0.8271\t2.1709",
        "1.6366\t1.2647\t-2.6452\t1.8223\t-0.4971\t0.5979\t2.3433\t-1.0294\t-0.8269\t-1.5069\t-2.6346\t-0.0719\t-1.8323\t-2.2969\t-2.8455\t-0.1375\t-0.3849\t-0.7521\t-0.8477\t-0.1198",
        "-0.6175\t-1.2297\t1.2197\t1.2485\t-0.0948\t1.4183\t-3.7251\t0.1405\t2.4242\t-0.2708\t-0.0664\t-0.2800\t1.9649\t-3.8964\t-4.0015\t0.2531\t0.7396\t0.1734\t-0.3145\t-0.8776",
        "2.7387\t0.8568\t-1.1949\t1.4882\t2.2466\t3.7466\t0.2387\t-0.9590\t-0.0420\t3.5025\t-0.5346\t-2.3431\t-0.0102\t-4.2069\t-1.1578\t1.3823\t-1.5142\t-2.1036\t1.7714\t4.4874",
        "0.5457\t-0.9845\t-0.1587\t-1.4552\t3.3668\t4.2413\t4.1022\t-0.1851\t-2.3077\t2.5795\t-0.9127\t-2.9361\t1.2825\t-7.4554\t-1.5414\t3.4749\t-0.9800\t4.4809\t4.7728\t3.6424",
        "-0.2741\t-0.8845\t1.7372\t-0.0969\t-1.4954\t1.2015\t-4.2471\t-1.1788\t4.4915\t-1.5540\t-3.7297\t0.6789\t2.7436\t2.5456\t3.3606\t-0.2064\t0.5935\t1.8966\t0.0026\t0.2615",
        "0.7329\t-2.1825\t0.0401\t-0.5229\t0.5086\t-0.6607\t0.9947\t1.4213\t0.3841\t-0.7424\t-1.7279\t1.2217\t0.2827\t-2.5906\t2.3848\t0.0699\t1.0055\t-3.3331\t1.0840\t-1.4767",
        "0.6182\t2.6465\t0.4493\t2.5818\t-5.7737\t1.6177\t-3.0636\t-0.7364\t2.0418\t-3.4718\t0.2138\t-1.2308\t0.4329\t1.6775\t-0.0187\t0.2129\t-0.7975\t-1.4801\t-2.6797\t-3.8428",
        "-1.1787\t-1.7681\t0.5857\t4.1118\t-0.5913\t-3.3774\t-4.6568\t-0.0334\t3.5675\t-0.4168\t2.9573\t0.3866\t3.7328\t2.4806\t1.9837\t0.3657\t0.5711\t-10.2215\t-0.2579\t-1.4140",
        "1.0799\t0.8449\t0.2453\t0.9705\t2.2293\t0.3701\t-6.7608\t0.8151\t5.6784\t2.8083\t0.5383\t-0.6699\t2.7289\t-3.5445\t-1.2149\t0.1752\t0.9559\t-2.9651\t0.7729\t6.5342",
        "1.1772\t0.5902\t-2.3611\t2.0941\t3.4715\t-0.7691\t3.6203\t1.0170\t-1.9883\t2.6255\t-0.3081\t1.4883\t-1.8289\t-2.4243\t-5.3778\t2.9992\t-0.5412\t-7.4438\t-2.5642\t3.7675",
        "-1.1967\t0.2924\t4.3650\t0.8240\t-2.4474\t0.7087\t-3.6837\t2.9900\t3.5126\t-1.6827\t-0.6423\t1.7077\t4.1402\t2.3348\t3.4332\t0.1896\t0.6287\t1.1611\t0.0811\t-2.4162"
    };

    public static final String[] SIM_20VARS_100CASES_4_ZERO_VARS = {
        "X0\tX1\tX2\tX3\tX4\tX5\tX6\tX7\tX8\tX9\tX10\tX11\tX12\tX13\tX14\tX15\tX16\tX17\tX18\tX19",
        "2.4475\t0.5148\t2.5901\t0.0\t1.4016\t0.0\t-7.9602\t1.1406\t4.4783\t1.8136\t0.0\t1.8451\t2.7634\t4.547\t8.3919\t0.0\t-1.6719\t-1.9283\t0.3101\t4.7454",
        "-0.8261\t0.0612\t-3.68\t0.0\t1.2874\t0.0\t4.1415\t-0.7477\t-0.5047\t0.6948\t0.0\t-1.0396\t0.5155\t0.7066\t-6.6644\t0.0\t2.0915\t-7.3785\t-5.5573\t2.3495",
        "0.2292\t-1.4067\t0.1086\t0.0\t-0.6666\t0.0\t3.4851\t1.2906\t1.1263\t0.3555\t0.0\t1.4814\t2.0138\t-0.2333\t-2.7676\t0.0\t4.8446\t-5.0355\t-2.1781\t-0.0119",
        "1.9147\t0.0218\t2.3734\t0.0\t1.284\t0.0\t-4.5019\t1.0082\t3.0217\t1.8572\t0.0\t1.5891\t5.4796\t-3.6909\t-8.8024\t0.0\t-0.5565\t-7.9374\t-4.9817\t3.5984",
        "2.1585\t2.0749\t-0.5698\t0.0\t3.7927\t0.0\t-1.0944\t-3.5404\t0.0533\t3.3814\t0.0\t-0.4686\t-1.126\t-3.7211\t1.2758\t0.0\t-2.5852\t-8.4607\t0.4123\t7.774",
        "0.5168\t-0.5694\t-0.2519\t0.0\t-1.7504\t0.0\t0.6082\t-2.1273\t-0.3188\t0.1038\t0.0\t-0.7415\t2.8601\t0.1616\t4.8135\t0.0\t0.9822\t2.0738\t1.7646\t1.6173",
        "1.2596\t-1.9587\t1.6036\t0.0\t2.8354\t0.0\t-0.1661\t-0.7514\t1.2414\t2.6244\t0.0\t1.3054\t1.8161\t-0.6625\t1.4514\t0.0\t2.9337\t1.1537\t1.3006\t2.7851",
        "2.2545\t-1.7264\t-4.2746\t0.0\t1.0999\t0.0\t3.4948\t-1.7983\t-3.5832\t1.2714\t0.0\t-0.0925\t1.1256\t-5.5139\t-5.3072\t0.0\t0.5733\t-2.4176\t0.191\t2.2937",
        "2.5974\t-2.6567\t-0.8007\t0.0\t-0.4938\t0.0\t4.3406\t0.2634\t-1.087\t0.2131\t0.0\t-0.2377\t-0.8496\t-2.0886\t4.6698\t0.0\t2.8557\t1.7209\t2.2693\t-0.0082",
        "4.0817\t1.2652\t-0.3697\t0.0\t4.6733\t0.0\t-0.3998\t-0.7225\t-0.6851\t3.8808\t0.0\t2.0703\t-0.7818\t-3.3961\t-5.0248\t0.0\t-0.3097\t-8.8967\t-2.1071\t6.7364",
        "4.2934\t-1.7388\t3.644\t0.0\t6.2376\t0.0\t-8.075\t2.4532\t5.1044\t3.7672\t0.0\t0.2177\t5.7758\t-2.2899\t-5.2073\t0.0\t-1.0698\t-2.378\t-2.0507\t4.4886",
        "0.2482\t0.4906\t-0.1887\t0.0\t-1.2547\t0.0\t0.7124\t1.2532\t-0.2168\t-1.0883\t0.0\t2.2192\t-0.1549\t-0.8263\t0.6217\t0.0\t1.1943\t-3.4099\t-2.0674\t-1.9044",
        "2.9179\t1.2948\t0.3419\t0.0\t3.8293\t0.0\t3.642\t-0.9043\t-1.0139\t3.0971\t0.0\t-1.3544\t0.3911\t-2.4326\t-3.7197\t0.0\t0.5564\t-2.0705\t-0.5663\t8.4511",
        "2.8987\t-2.5516\t3.0141\t0.0\t3.852\t0.0\t-0.1814\t3.8657\t4.4168\t3.4178\t0.0\t0.8822\t1.6017\t1.1801\t5.3376\t0.0\t5.999\t-2.2499\t2.2234\t1.8563",
        "-1.1119\t-1.5893\t1.3631\t0.0\t-1.4975\t0.0\t-3.4887\t-0.2593\t3.0309\t-1.6984\t0.0\t-1.3621\t1.1668\t-0.639\t-4.2616\t0.0\t2.8418\t-6.2019\t-1.8364\t-4.1138",
        "-0.9366\t0.058\t-1.2384\t0.0\t-5.3792\t0.0\t3.1123\t-1.2709\t-1.6082\t-2.5846\t0.0\t-1.3165\t-1.4265\t1.7074\t-0.5154\t0.0\t-0.6591\t0.5071\t-2.1097\t-3.8528",
        "2.6506\t1.6498\t-1.2563\t0.0\t5.3056\t0.0\t2.1284\t1.1077\t-1.7831\t4.3837\t0.0\t-0.3992\t1.4613\t-4.2116\t-6.0423\t0.0\t-0.5594\t-1.0612\t-1.4046\t8.5562",
        "1.0616\t0.0572\t-6.8795\t0.0\t1.9479\t0.0\t4.5561\t-3.3336\t-4.7284\t1.1154\t0.0\t-1.1081\t-3.6129\t-6.5786\t-7.4592\t0.0\t-1.4994\t-1.8526\t-2.4531\t4.1859",
        "0.4199\t-2.8658\t0.4329\t0.0\t-0.4045\t0.0\t1.0809\t0.1481\t-1.3748\t-0.9559\t0.0\t1.3496\t1.9618\t-0.3696\t0.2818\t0.0\t0.9875\t-0.1738\t-1.2715\t-3.4429",
        "1.205\t-1.7159\t-0.4386\t0.0\t0.1358\t0.0\t0.6783\t0.7553\t0.714\t-1.1502\t0.0\t0.2395\t1.7842\t-2.9939\t-7.2118\t0.0\t3.024\t-4.3969\t-2.5256\t-2.1392",
        "1.5317\t-0.3299\t-0.276\t0.0\t1.0164\t0.0\t2.4241\t0.8473\t-0.6664\t-0.6358\t0.0\t0.2547\t0.0113\t2.1424\t-2.6342\t0.0\t2.1853\t-1.5524\t-1.9927\t-0.2187",
        "-2.3024\t0.6194\t1.0104\t0.0\t-1.5746\t0.0\t-4.035\t-1.4985\t1.2808\t-1.0172\t0.0\t0.7418\t1.5386\t-0.9582\t3.2691\t0.0\t-1.8542\t2.0355\t4.3337\t0.378",
        "2.0921\t-2.2457\t1.8116\t0.0\t1.0377\t0.0\t-0.4859\t0.3136\t0.0538\t0.6599\t0.0\t-0.7548\t1.3804\t-1.8415\t-2.5517\t0.0\t-0.3893\t0.3262\t-0.1488\t0.2176",
        "-0.8636\t-0.2439\t-2.073\t0.0\t0.0454\t0.0\t6.7465\t0.1813\t-4.1367\t-0.9562\t0.0\t-2.6325\t-0.4727\t-1.5548\t-3.627\t0.0\t2.5313\t-2.7573\t-1.0343\t1.9485",
        "1.6355\t-1.9667\t0.5765\t0.0\t3.6648\t0.0\t0.206\t1.2069\t1.9853\t2.0676\t0.0\t-0.4788\t2.1729\t0.7324\t-2.3395\t0.0\t2.4807\t-6.1992\t-5.1651\t1.0423",
        "0.0755\t-0.4904\t1.5176\t0.0\t-4.8818\t0.0\t3.3279\t0.8487\t2.0046\t-3.2029\t0.0\t-1.399\t0.0056\t4.0297\t8.1024\t0.0\t2.8646\t1.6\t1.066\t-5.1078",
        "0.7746\t0.5618\t-1.6925\t0.0\t-2.29\t0.0\t5.1482\t0.7254\t-3.351\t-1.3639\t0.0\t0.4053\t-2.9274\t-1.1685\t-2.8904\t0.0\t-1.1954\t1.9446\t-2.2501\t-1.5918",
        "2.3914\t-0.503\t-0.741\t0.0\t1.8204\t0.0\t0.2328\t-2.3533\t0.315\t1.7797\t0.0\t-2.2373\t0.5248\t-2.7627\t-0.4959\t0.0\t1.6545\t-0.3104\t-0.5741\t4.3134",
        "0.8044\t-1.7096\t1.4422\t0.0\t-1.1369\t0.0\t-3.6865\t1.1678\t3.4983\t-0.6598\t0.0\t-0.7528\t5.0916\t0.9454\t-1.6296\t0.0\t1.9893\t-7.6924\t-1.9952\t-0.7175",
        "-0.6763\t-2.5612\t2.3629\t0.0\t-2.8383\t0.0\t3.6226\t1.4349\t-1.0072\t-1.5071\t0.0\t-1.846\t1.3737\t0.233\t8.7473\t0.0\t3.8783\t5.2535\t3.0152\t-1.6194",
        "0.8409\t0.3501\t1.1308\t0.0\t0.5177\t0.0\t2.0831\t-1.1045\t1.5812\t1.2542\t0.0\t-1.1148\t0.5273\t-1.9085\t4.6715\t0.0\t0.4276\t-1.6229\t1.1631\t2.4368",
        "-0.607\t-2.1694\t2.2846\t0.0\t-0.1394\t0.0\t1.4425\t0.364\t0.587\t0.2209\t0.0\t-0.3494\t0.0962\t-0.4401\t-0.1865\t0.0\t1.1855\t0.4865\t2.1879\t-0.0417",
        "0.6439\t-1.5808\t-4.6276\t0.0\t0.5527\t0.0\t3.8518\t1.0461\t-1.1847\t1.1029\t0.0\t-2.4753\t0.1732\t-2.3727\t-2.0466\t0.0\t0.461\t-3.8333\t-1.6151\t2.2055",
        "2.7797\t-0.4572\t-1.5701\t0.0\t0.7028\t0.0\t1.3191\t-0.0416\t-0.2795\t0.5251\t0.0\t-0.644\t2.6322\t-2.7746\t1.3007\t0.0\t-0.5035\t-3.0676\t3.5854\t2.3912",
        "-0.2572\t-0.7279\t-1.0248\t0.0\t0.2429\t0.0\t7.6927\t0.8364\t-4.2916\t0.787\t0.0\t-0.9394\t-2.0129\t-5.3083\t2.2763\t0.0\t1.8082\t1.9445\t3.1768\t1.6015",
        "0.7578\t0.881\t2.5254\t0.0\t3.4391\t0.0\t-4.2251\t2.5357\t2.7574\t2.0285\t0.0\t1.0511\t1.1949\t1.0157\t0.8135\t0.0\t-0.2814\t-4.8634\t-1.1518\t3.8934",
        "-0.3693\t2.2174\t0.1315\t0.0\t-0.933\t0.0\t-3.9261\t0.4521\t1.7584\t-2.723\t0.0\t1.0537\t4.1297\t1.947\t1.4201\t0.0\t-0.6298\t4.2087\t0.7232\t-0.4007",
        "2.2084\t-0.4681\t0.5309\t0.0\t4.3842\t0.0\t0.6151\t1.0655\t0.6619\t6.0377\t0.0\t-0.0696\t2.4417\t-4.4767\t-8.3183\t0.0\t1.4896\t-2.4827\t-0.5595\t9.2166",
        "-0.1739\t-1.6893\t2.5416\t0.0\t-2.4241\t0.0\t-1.1156\t1.4014\t2.8068\t-2.235\t0.0\t0.181\t1.6174\t1.1195\t0.8393\t0.0\t1.5266\t4.0936\t-0.4719\t-3.6294",
        "0.6553\t-1.195\t0.4422\t0.0\t3.4499\t0.0\t-0.2301\t-0.7643\t0.5075\t1.5766\t0.0\t-3.4762\t0.1182\t-3.9408\t-1.267\t0.0\t1.5167\t-3.4432\t-1.8508\t2.8323",
        "0.8325\t-2.5921\t0.6404\t0.0\t1.5503\t0.0\t5.2815\t-0.908\t-0.8045\t0.0642\t0.0\t-0.3456\t0.4359\t-1.5804\t1.3908\t0.0\t4.7732\t1.0605\t-0.4153\t-1.6345",
        "-0.2103\t-0.7416\t4.1806\t0.0\t-0.3306\t0.0\t-4.2063\t2.375\t2.8245\t-0.0917\t0.0\t0.4987\t3.3026\t-1.2096\t-3.0972\t0.0\t2.4045\t-0.8084\t-1.2766\t-0.5012",
        "0.8905\t0.3991\t-2.6118\t0.0\t-1.581\t0.0\t4.8951\t-1.6346\t-2.7264\t-0.8695\t0.0\t1.1699\t-1.6267\t2.1477\t8.2337\t0.0\t0.7314\t-2.0499\t2.0242\t0.0514",
        "-0.9339\t-0.6898\t0.879\t0.0\t-1.346\t0.0\t6.1549\t-0.8925\t-2.0593\t-2.0431\t0.0\t0.4427\t-1.885\t-1.1046\t3.5203\t0.0\t2.7417\t2.8654\t0.8973\t-2.8877",
        "1.3198\t-0.0568\t-1.4067\t0.0\t4.033\t0.0\t-0.6983\t1.261\t-0.1643\t2.8966\t0.0\t-0.5599\t0.972\t-5.7969\t-6.4607\t0.0\t-0.9795\t-4.8529\t-0.5538\t5.0057",
        "1.9122\t2.6697\t-0.0733\t0.0\t1.1097\t0.0\t0.1787\t0.3786\t0.4735\t2.1046\t0.0\t-0.6409\t-3.6624\t-2.7689\t-3.1803\t0.0\t-0.7645\t-3.042\t-2.0066\t8.2186",
        "0.5757\t0.7306\t-0.853\t0.0\t-0.8475\t0.0\t-3.3056\t0.2459\t1.2729\t-0.4492\t0.0\t-0.1049\t1.3956\t-1.6429\t3.6204\t0.0\t0.7714\t-1.199\t1.5639\t-0.116",
        "1.2642\t-0.1861\t-1.2334\t0.0\t1.6861\t0.0\t-3.8992\t-0.154\t2.4347\t1.0435\t0.0\t-3.4039\t0.776\t-1.1505\t-2.8299\t0.0\t0.4016\t-6.1462\t-3.4459\t3.2258",
        "3.6509\t-1.2284\t0.0588\t0.0\t3.2853\t0.0\t2.6423\t1.7226\t0.5746\t4.1479\t0.0\t-0.2995\t-0.0405\t-1.4066\t1.0767\t0.0\t3.1722\t-0.5746\t0.0882\t4.934",
        "2.0233\t-0.5505\t0.2958\t0.0\t-0.5798\t0.0\t0.7121\t0.8096\t1.0026\t-1.5564\t0.0\t-1.0154\t2.8876\t1.4277\t0.285\t0.0\t1.5442\t-0.1771\t-1.0988\t-1.3096",
        "0.2312\t2.6839\t0.2297\t0.0\t0.4224\t0.0\t-4.1428\t-0.2245\t0.6513\t-0.413\t0.0\t-1.8812\t0.4171\t-1.4307\t-6.2277\t0.0\t-4.1343\t1.1368\t-2.7231\t2.9605",
        "-2.2815\t-1.3124\t3.103\t0.0\t-3.5084\t0.0\t0.6591\t3.1242\t0.917\t-4.2952\t0.0\t-0.1992\t3.0259\t5.1578\t3.691\t0.0\t1.6163\t2.9335\t-0.0826\t-6.6092",
        "-2.0546\t-0.9269\t-0.6458\t0.0\t-6.8313\t0.0\t7.1038\t0.4871\t-3.0521\t-6.1405\t0.0\t0.7781\t-2.5098\t5.3018\t0.3887\t0.0\t1.59\t2.9527\t-1.6258\t-8.1122",
        "-0.2431\t0.1304\t0.2485\t0.0\t-4.279\t0.0\t-0.7287\t0.3591\t0.284\t-3.4765\t0.0\t0.6112\t2.4832\t4.6811\t9.8138\t0.0\t0.8919\t0.678\t2.6302\t-6.1251",
        "5.2251\t-1.711\t-1.3135\t0.0\t8.3319\t0.0\t-1.5256\t-0.1003\t1.445\t7.7236\t0.0\t0.3339\t0.9197\t-5.4133\t-2.1043\t0.0\t0.3423\t-8.2265\t1.4392\t11.4168",
        "1.1737\t0.2502\t-1.0696\t0.0\t-1.1345\t0.0\t-1.0875\t0.9829\t0.5294\t-1.5316\t0.0\t-1.1776\t-0.0014\t0.216\t-0.0968\t0.0\t1.2706\t-2.0374\t-0.8179\t-2.0914",
        "2.8153\t-1.6111\t-1.3506\t0.0\t-0.5653\t0.0\t2.9775\t-2.1029\t-1.8694\t0.2209\t0.0\t0.4491\t-0.4973\t0.251\t3.1618\t0.0\t2.5785\t-1.896\t0.4465\t-0.1357",
        "1.0846\t-1.2755\t1.9089\t0.0\t-0.9984\t0.0\t-5.3603\t-0.8535\t2.4873\t-1.3322\t0.0\t-1.1141\t1.7144\t2.073\t3.0407\t0.0\t1.8336\t0.1291\t-0.5794\t-2.9642",
        "1.8066\t-0.3969\t-3.6562\t0.0\t1.6054\t0.0\t3.8171\t2.3625\t-4.3248\t1.7022\t0.0\t1.8761\t-4.0742\t-5.3503\t-4.1806\t0.0\t0.4861\t-2.6142\t0.9534\t3.9786",
        "0.9535\t-1.0894\t1.8698\t0.0\t2.8191\t0.0\t-1.2741\t1.757\t1.246\t2.0994\t0.0\t0.4767\t-0.2655\t0.8587\t-6.1658\t0.0\t1.5036\t-3.9114\t-5.1247\t3.6754",
        "-0.3082\t-0.0211\t0.0923\t0.0\t1.9561\t0.0\t1.1801\t0.3613\t-0.6304\t1.3859\t0.0\t-0.4424\t0.9545\t-3.4929\t8.0112\t0.0\t0.7259\t1.1581\t4.6831\t4.1062",
        "2.0292\t-2.2799\t0.2288\t0.0\t-0.0404\t0.0\t1.3355\t0.5389\t0.2032\t0.9432\t0.0\t0.1448\t1.3214\t-0.3801\t-2.4233\t0.0\t4.4015\t-1.0199\t-1.6206\t1.3914",
        "-0.1509\t-3.3245\t1.7004\t0.0\t-1.7328\t0.0\t1.2647\t4.4269\t0.3526\t-1.3134\t0.0\t-1.1185\t0.2283\t0.179\t1.2441\t0.0\t1.5886\t4.0556\t0.6991\t-1.1818",
        "1.611\t-0.5821\t2.4068\t0.0\t0.5097\t0.0\t-1.258\t1.4168\t3.822\t1.3094\t0.0\t-0.8808\t2.5004\t5.5535\t6.048\t0.0\t2.1264\t-2.2661\t-0.5156\t3.9814",
        "0.5334\t1.2651\t0.0844\t0.0\t0.3424\t0.0\t-0.0896\t1.1334\t1.0061\t0.9492\t0.0\t-1.6198\t2.488\t0.3017\t2.0556\t0.0\t-0.6193\t-2.3232\t-0.3074\t3.7661",
        "2.5524\t0.7733\t-0.4328\t0.0\t3.7122\t0.0\t3.398\t-0.906\t-4.139\t3.7224\t0.0\t-1.5822\t-5.567\t-5.3087\t-3.7299\t0.0\t1.049\t-0.7074\t1.106\t6.5105",
        "2.2154\t-0.1846\t0.4073\t0.0\t-0.1659\t0.0\t2.1663\t0.5845\t-0.213\t0.3217\t0.0\t1.3409\t-0.012\t-0.8398\t-0.7494\t0.0\t0.102\t-2.5196\t-0.5367\t1.9681",
        "0.3749\t-1.8464\t0.5317\t0.0\t-4.1062\t0.0\t0.2807\t1.4903\t0.6306\t-3.448\t0.0\t0.1057\t2.3074\t2.0308\t2.2953\t0.0\t0.9622\t7.8599\t2.5715\t-4.2071",
        "3.2841\t1.818\t0.4806\t0.0\t2.3569\t0.0\t-1.3229\t-0.1482\t0.2549\t3.0145\t0.0\t0.8415\t0.9316\t-2.6632\t3.2185\t0.0\t-1.5243\t-3.0824\t4.0015\t5.1993",
        "-1.3616\t0.3457\t-3.2672\t0.0\t-3.3125\t0.0\t8.4952\t0.2283\t-4.1974\t-4.0051\t0.0\t1.4525\t-4.0478\t1.6355\t1.3328\t0.0\t-0.9331\t4.1466\t-2.4328\t-4.7343",
        "4.3239\t-2.1597\t3.1244\t0.0\t2.8861\t0.0\t0.9866\t4.8809\t0.7018\t3.1752\t0.0\t-0.0051\t4.2382\t0.3546\t7.3936\t0.0\t0.9476\t-1.4572\t0.622\t1.7835",
        "1.3463\t1.7423\t2.7436\t0.0\t-1.8446\t0.0\t-0.6409\t0.308\t1.5986\t-1.3053\t0.0\t0.6474\t2.9759\t1.2027\t-0.0615\t0.0\t-0.7788\t3.7424\t-0.2311\t-1.0123",
        "2.5283\t0.2716\t-1.5867\t0.0\t1.2667\t0.0\t0.0046\t0.8197\t-0.3302\t0.8915\t0.0\t1.4343\t-1.676\t-0.9379\t-3.7694\t0.0\t2.3917\t0.3713\t-1.5788\t2.4365",
        "1.8545\t3.0814\t-0.1622\t0.0\t-0.6657\t0.0\t-9.0096\t0.1225\t4.7337\t0.3549\t0.0\t-0.097\t3.8681\t0.5885\t-2.9449\t0.0\t-2.2809\t-4.1934\t-3.5288\t2.344",
        "0.8074\t0.4546\t1.1418\t0.0\t-0.0251\t0.0\t-3.1544\t-0.9442\t2.644\t0.937\t0.0\t-1.0453\t1.9046\t-2.0594\t2.2407\t0.0\t0.2648\t1.5155\t0.7075\t2.8266",
        "0.1151\t-1.4043\t1.7932\t0.0\t-3.9618\t0.0\t3.9457\t0.1494\t0.4761\t-3.9539\t0.0\t-0.9607\t-1.5116\t2.6982\t6.3397\t0.0\t3.0244\t1.3016\t1.5632\t-5.1783",
        "1.6417\t-2.4861\t0.0021\t0.0\t3.5571\t0.0\t-3.0739\t1.0272\t-0.1164\t2.3699\t0.0\t-1.0419\t-0.7962\t-1.871\t-1.0774\t0.0\t0.999\t-2.3686\t0.5367\t3.5426",
        "2.9061\t-0.3892\t0.2641\t0.0\t0.281\t0.0\t2.2548\t0.8492\t0.3276\t0.6711\t0.0\t1.1615\t2.4218\t-2.4531\t2.3278\t0.0\t1.24\t3.8978\t2.1902\t2.6461",
        "1.2637\t1.15\t-2.6028\t0.0\t2.8143\t0.0\t3.4137\t-2.0078\t-1.76\t3.2665\t0.0\t-0.977\t-2.0093\t-2.9083\t-3.5894\t0.0\t-0.4799\t-1.1321\t-0.4652\t6.0287",
        "-2.5917\t0.2817\t-0.8595\t0.0\t-6.2997\t0.0\t-0.5076\t-0.4028\t0.1375\t-5.7381\t0.0\t1.0155\t0.2037\t6.1389\t-0.9872\t0.0\t-1.2472\t3.0213\t-4.4681\t-6.6417",
        "-0.4888\t-2.9672\t-0.713\t0.0\t-2.5752\t0.0\t-0.401\t0.7308\t0.4128\t-2.064\t0.0\t-0.5952\t2.4228\t-2.223\t-1.3499\t0.0\t2.0119\t-0.2697\t-1.29\t-3.522",
        "0.3328\t1.5121\t2.6296\t0.0\t0.52\t0.0\t-2.5948\t0.5604\t2.3917\t0.6725\t0.0\t1.4365\t1.4773\t2.1887\t7.5375\t0.0\t-1.1831\t3.7736\t3.5739\t4.0653",
        "2.9204\t0.9746\t0.7452\t0.0\t3.6091\t0.0\t-0.3315\t2.4437\t-0.4283\t2.8694\t0.0\t-0.1776\t-0.7071\t-4.1941\t-3.6185\t0.0\t1.5293\t-6.0113\t0.177\t6.4824",
        "-0.3308\t-0.1153\t1.1079\t0.0\t-0.7125\t0.0\t-2.2819\t-0.2728\t0.5188\t-1.7304\t0.0\t1.4098\t1.6454\t3.5467\t3.4344\t0.0\t0.8194\t-0.9961\t-1.4795\t0.0123",
        "1.4871\t-0.857\t2.8789\t0.0\t3.0447\t0.0\t-2.4923\t2.2951\t3.8291\t1.9053\t0.0\t-0.7375\t1.7182\t0.1076\t-2.1231\t0.0\t1.8127\t2.131\t-1.6106\t4.1432",
        "0.0055\t2.9826\t0.709\t0.0\t0.0379\t0.0\t-1.6556\t1.7642\t0.9926\t-0.9529\t0.0\t-0.1749\t0.93\t0.8178\t9.2045\t0.0\t-1.5158\t-0.5508\t4.5654\t1.1158",
        "2.3902\t-1.2448\t2.5911\t0.0\t4.3791\t0.0\t-2.1351\t0.2384\t2.1421\t5.4463\t0.0\t-0.4862\t1.4041\t-4.7752\t1.7838\t0.0\t0.5348\t-2.2806\t1.5181\t7.5271",
        "1.214\t-2.6516\t4.1514\t0.0\t1.4209\t0.0\t-6.7655\t-0.6342\t5.4545\t0.7298\t0.0\t-1.3513\t7.4328\t1.7019\t4.2348\t0.0\t3.4361\t-1.5155\t1.4892\t0.5636",
        "1.8245\t-0.5152\t-0.0908\t0.0\t1.7199\t0.0\t-3.0173\t-0.2062\t0.8712\t0.7739\t0.0\t-0.016\t1.0135\t-1.4954\t0.4661\t0.0\t0.0069\t-1.4145\t0.8271\t2.1709",
        "1.6366\t1.2647\t-2.6452\t0.0\t-0.4971\t0.0\t2.3433\t-1.0294\t-0.8269\t-1.5069\t0.0\t-0.0719\t-1.8323\t-2.2969\t-2.8455\t0.0\t-0.3849\t-0.7521\t-0.8477\t-0.1198",
        "-0.6175\t-1.2297\t1.2197\t0.0\t-0.0948\t0.0\t-3.7251\t0.1405\t2.4242\t-0.2708\t0.0\t-0.28\t1.9649\t-3.8964\t-4.0015\t0.0\t0.7396\t0.1734\t-0.3145\t-0.8776",
        "2.7387\t0.8568\t-1.1949\t0.0\t2.2466\t0.0\t0.2387\t-0.959\t-0.042\t3.5025\t0.0\t-2.3431\t-0.0102\t-4.2069\t-1.1578\t0.0\t-1.5142\t-2.1036\t1.7714\t4.4874",
        "0.5457\t-0.9845\t-0.1587\t0.0\t3.3668\t0.0\t4.1022\t-0.1851\t-2.3077\t2.5795\t0.0\t-2.9361\t1.2825\t-7.4554\t-1.5414\t0.0\t-0.98\t4.4809\t4.7728\t3.6424",
        "-0.2741\t-0.8845\t1.7372\t0.0\t-1.4954\t0.0\t-4.2471\t-1.1788\t4.4915\t-1.554\t0.0\t0.6789\t2.7436\t2.5456\t3.3606\t0.0\t0.5935\t1.8966\t0.0026\t0.2615",
        "0.7329\t-2.1825\t0.0401\t0.0\t0.5086\t0.0\t0.9947\t1.4213\t0.3841\t-0.7424\t0.0\t1.2217\t0.2827\t-2.5906\t2.3848\t0.0\t1.0055\t-3.3331\t1.084\t-1.4767",
        "0.6182\t2.6465\t0.4493\t0.0\t-5.7737\t0.0\t-3.0636\t-0.7364\t2.0418\t-3.4718\t0.0\t-1.2308\t0.4329\t1.6775\t-0.0187\t0.0\t-0.7975\t-1.4801\t-2.6797\t-3.8428",
        "-1.1787\t-1.7681\t0.5857\t0.0\t-0.5913\t0.0\t-4.6568\t-0.0334\t3.5675\t-0.4168\t0.0\t0.3866\t3.7328\t2.4806\t1.9837\t0.0\t0.5711\t-10.2215\t-0.2579\t-1.414",
        "1.0799\t0.8449\t0.2453\t0.0\t2.2293\t0.0\t-6.7608\t0.8151\t5.6784\t2.8083\t0.0\t-0.6699\t2.7289\t-3.5445\t-1.2149\t0.0\t0.9559\t-2.9651\t0.7729\t6.5342",
        "1.1772\t0.5902\t-2.3611\t0.0\t3.4715\t0.0\t3.6203\t1.017\t-1.9883\t2.6255\t0.0\t1.4883\t-1.8289\t-2.4243\t-5.3778\t0.0\t-0.5412\t-7.4438\t-2.5642\t3.7675",
        "-1.1967\t0.2924\t4.365\t0.0\t-2.4474\t0.0\t-3.6837\t2.99\t3.5126\t-1.6827\t0.0\t1.7077\t4.1402\t2.3348\t3.4332\t0.0\t0.6287\t1.1611\t0.0811\t-2.4162"
    };

    public final String[] SIM_20VARS_100CASES_KNOWLEDGE = {
        "/knowledge",
        "requiredirect",
        "X12 X8",
        "",
        "forbiddirect",
        "X5 X17"
    };

    public final String[] SIM_20VARS_100CASES_COVARIANCE = {
        "100",
        "X0\tX1\tX2\tX3\tX4\tX5\tX6\tX7\tX8\tX9\tX10\tX11\tX12\tX13\tX14\tX15\tX16\tX17\tX18\tX19",
        "2.2882",
        "0.0651\t2.1562",
        "-0.1483\t-0.5765\t3.8617",
        "0.2736\t0.2903\t-0.5775\t2.1348",
        "2.9503\t0.0296\t-0.1878\t0.6829\t7.5988",
        "0.2430\t0.1188\t0.0193\t-0.6630\t0.2174\t3.1125",
        "-0.5408\t-0.7981\t-3.7230\t-1.3421\t-1.4688\t0.8349\t12.7287",
        "0.0878\t-0.5150\t1.3054\t-0.1665\t0.1809\t-0.1217\t-0.6782\t2.1039",
        "0.1825\t-0.1372\t3.1831\t0.6844\t0.3670\t-0.5445\t-6.9052\t0.9333\t5.2081",
        "2.7918\t0.1468\t-0.1573\t0.5677\t6.3757\t0.5291\t-1.1860\t0.0401\t0.3881\t6.0529",
        "-0.1212\t-0.4226\t-0.5371\t-0.3216\t0.3391\t-0.1757\t0.7760\t-0.3454\t-0.6339\t0.3836\t2.6898",
        "0.0441\t0.1163\t0.3190\t-0.1876\t-0.2700\t-0.2953\t-0.3385\t0.3997\t0.1579\t-0.2887\t-0.2762\t1.4897",
        "0.0880\t-0.6624\t2.5716\t0.2230\t0.1627\t-0.0982\t-5.1079\t0.8716\t3.7109\t0.1055\t-0.1427\t0.1434\t4.7759",
        "-1.9263\t-0.1452\t2.1843\t-0.0939\t-5.0503\t-0.6024\t-1.6930\t0.8451\t2.2811\t-4.6167\t-0.8685\t0.8529\t1.6052\t8.1759",
        "-1.2895\t-0.5067\t3.0462\t-3.3951\t-4.3738\t0.1085\t-0.2845\t0.4905\t1.7671\t-3.3474\t-0.2337\t0.5114\t1.4922\t6.3729\t18.2177",
        "0.0008\t-0.1322\t-0.3582\t0.0543\t0.0734\t0.2976\t-0.1102\t0.2607\t-0.3851\t-0.1998\t0.2206\t0.0294\t0.1964\t-0.5411\t-3.1037\t2.6438",
        "-0.0895\t-1.6985\t0.7389\t-0.1685\t-0.3349\t-0.3949\t1.6334\t0.6068\t0.2546\t-0.3404\t0.3154\t-0.0592\t0.3041\t0.8272\t1.0913\t-0.3121\t2.9505",
        "-1.9242\t-0.4606\t1.3128\t-3.6031\t-4.7561\t3.5011\t2.7895\t0.3305\t-1.1968\t-4.1604\t-0.2424\t-0.0467\t-0.3718\t2.7377\t6.1464\t0.4171\t0.2721\t11.9692",
        "0.1469\t-0.2001\t0.7074\t-2.3270\t0.1166\t0.6925\t0.5975\t-0.0530\t-0.3144\t0.4452\t0.5165\t-0.0744\t0.1833\t-0.8508\t6.0819\t-0.2205\t0.0312\t3.0783\t4.8211",
        "3.9467\t1.6785\t-0.9798\t0.9288\t9.3180\t1.1160\t-1.9870\t-0.5274\t0.1678\t8.8065\t0.3668\t-0.5781\t-0.5325\t-6.9778\t-5.4919\t-0.3751\t-1.7633\t-5.8260\t0.6118\t14.8996"
    };

    public final String[] SIM_20VARS_100CASES_VARIABLES = {
        "X3",
        "X10",
        "X15",
        "X18"
    };

}
