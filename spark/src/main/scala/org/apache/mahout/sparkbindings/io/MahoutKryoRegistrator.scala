/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.mahout.sparkbindings.io

import com.esotericsoftware.kryo.Kryo
import com.esotericsoftware.kryo.serializers.JavaSerializer
import com.google.common.collect.HashBiMap
import org.apache.mahout.math._
import org.apache.spark.serializer.KryoRegistrator
import org.apache.mahout.sparkbindings._
import org.apache.mahout.common.Pair
import org.apache.mahout.math.Vector.Element

import scala.collection.immutable.List

/** Kryo serialization registrator for Mahout */
class MahoutKryoRegistrator extends KryoRegistrator {

  override def registerClasses(kryo: Kryo) = {

    kryo.addDefaultSerializer(classOf[Vector], new WritableKryoSerializer[Vector, VectorWritable])
    kryo.addDefaultSerializer(classOf[DenseVector], new WritableKryoSerializer[Vector, VectorWritable])
    kryo.addDefaultSerializer(classOf[Matrix], new WritableKryoSerializer[Matrix, MatrixWritable])
    kryo.register(classOf[com.google.common.collect.HashBiMap[String, Int]], new JavaSerializer())
  }
}
